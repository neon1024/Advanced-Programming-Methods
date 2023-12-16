package model;

import model.adts.IDictionary;
import model.adts.IHeap;
import model.adts.IList;
import model.adts.IStack;
import exceptions.ADTException;
import exceptions.ProgramStateException;
import exceptions.StatementException;
import model.statements.Statement;
import model.values.Value;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ProgramState {
    private final Statement originalProgram;  // backup for the program
    private final IStack<Statement> executionStack;
    private final IDictionary<String, Value> tableOfSymbols;
    private final IList<Value> output;
    private final IDictionary<String, BufferedReader> fileTable;
    private final IHeap heap;
    private final int id;
    private static final Set<Integer> ids = new HashSet<>();

    public ProgramState(Statement originalProgram,
                        IStack<Statement> executionStack, IDictionary<String, Value> tableOfSymbols,
                        IHeap heap, IDictionary<String, BufferedReader> fileTable,
                        IList<Value> output) {

        this.originalProgram = originalProgram.deepCopy();
        this.executionStack = executionStack;
        this.tableOfSymbols = tableOfSymbols;
        this.output = output;
        this.fileTable = fileTable;
        this.heap = heap;

        this.id = ProgramState.generateNewId();
        executionStack.push(originalProgram);
    }

    private static int generateNewId() {
        Random random = new Random();
        int id;

        synchronized (ProgramState.ids) {
            do {
                id = random.nextInt();
            } while (ProgramState.ids.contains(id));

            ProgramState.ids.add(id);
        }

        return id;
    }

    public int getId() {
        return this.id;
    }

    public IStack<Statement> getExecutionStack() {
        return this.executionStack;
    }

    public IDictionary<String, Value> getTableOfSymbols() {
        return this.tableOfSymbols;
    }

    public IList<Value> getOutput() {
        return this.output;
    }

    public IDictionary<String, BufferedReader> getFileTable() {
        return this.fileTable;
    }

    public IHeap getHeap() {
        return this.heap;
    }

    public boolean isNotCompleted() {
        return !this.executionStack.isEmpty();
    }

    public ProgramState oneStep() throws ProgramStateException {
        if (this.executionStack.isEmpty()) {
            throw new ProgramStateException("Execution stack is empty!");
        }

        try {
            Statement currentStatement = this.executionStack.pop();

            return currentStatement.execute(this);

        } catch (StatementException | ADTException e) {
            throw new ProgramStateException(e.getMessage());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Program State: ").append(this.id).append("\n");
        stringBuilder.append("Execution Stack:\n");

        if (this.executionStack.isEmpty()) {
            stringBuilder.append("-----------------------------Empty------------------------------\n");
        } else {
            stringBuilder.append(this.executionStack);
        }

        stringBuilder.append("----------------------------------------------------------------\n\n");
        stringBuilder.append("Symbol Table:\n");

        if (this.tableOfSymbols.isEmpty()) {
            stringBuilder.append("-----------------------------Empty------------------------------\n");
        } else {
            stringBuilder.append(this.tableOfSymbols);
        }

        stringBuilder.append("----------------------------------------------------------------\n\n");
        stringBuilder.append("Heap:\n");

        if (this.heap.isEmpty()) {
            stringBuilder.append("-----------------------------Empty------------------------------\n");
        } else {
            stringBuilder.append(this.heap);
        }

        stringBuilder.append("----------------------------------------------------------------\n\n");
        stringBuilder.append("File Table:\n");

        if (this.fileTable.isEmpty()) {
            stringBuilder.append("-----------------------------Empty------------------------------\n");
        } else {
            stringBuilder.append(this.fileTable);
        }

        stringBuilder.append("----------------------------------------------------------------\n\n");
        stringBuilder.append("Output:\n");

        if (this.output.isEmpty()) {
            stringBuilder.append("-----------------------------Empty------------------------------\n");
        } else {
            stringBuilder.append(this.output);
        }

        stringBuilder.append("----------------------------------------------------------------\n\n");

        stringBuilder.append("################################################################");

        return stringBuilder.toString();
    }
}
