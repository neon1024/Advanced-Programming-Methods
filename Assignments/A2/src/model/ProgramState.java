package model;

import model.adt.*;
import model.statements.Statement;
import model.values.Value;

public class ProgramState {
    private final IStack<Statement> executionStack;
    private final IDict<String, Value> tableOfSymbols;
    private final IList<String> output;
    private final IList<String> fileTable;

    public ProgramState(Statement originalProgram) {
        executionStack = new Stack<>();
        tableOfSymbols = new Dict<>();
        output = new List<>();
        fileTable = new List<>();
        executionStack.push(originalProgram);
    }

    public IStack<Statement> getExecutionStack() {
        return executionStack;
    }

    public IDict<String, Value> getSymTable() {
        return tableOfSymbols;
    }

    public IList<String> getOut() {
        return output;
    }

    public ProgramState(IStack<Statement> executionStack,
                        IDict<String, Value> tableOfSymbols,
                        IList<String> output,
                        IList<String> fileTable) {
        this.executionStack = executionStack;
        this.tableOfSymbols = tableOfSymbols;
        this.output = output;
        this.fileTable = fileTable;
    }
}
