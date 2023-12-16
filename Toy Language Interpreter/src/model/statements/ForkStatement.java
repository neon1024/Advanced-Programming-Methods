package model.statements;

import exceptions.StatementException;
import model.ProgramState;
import model.adts.IDictionary;
import model.adts.IHeap;
import model.adts.IList;
import model.adts.MyStack;
import model.types.Type;
import model.values.Value;

import java.io.BufferedReader;

public class ForkStatement implements Statement {

    private final Statement statement;

    public ForkStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        MyStack<Statement> newExecutionStack = new MyStack<>();
        IDictionary<String, Value> newTableOfSymbols = programState.getTableOfSymbols().deepCopy();

        return new ProgramState(this.statement, newExecutionStack, newTableOfSymbols, programState.getHeap(), programState.getFileTable(), programState.getOutput());
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        this.statement.typeCheck(typeEnvironment.deepCopy());

        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new ForkStatement(this.statement.deepCopy());
    }

    public String toString() {
        return "fork(" + this.statement + ")";
    }
}
