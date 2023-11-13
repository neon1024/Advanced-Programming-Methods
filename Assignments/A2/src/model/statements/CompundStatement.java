package model.statements;

import exceptions.InterpreterException;
import model.ProgramState;
import model.adt.IDict;
import model.adt.IStack;
import model.types.Type;

public class CompundStatement implements Statement {

    private final Statement first;
    private final Statement second;

    public CompundStatement(Statement first, Statement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<Statement> stack =  state.getExecutionStack();
        stack.push(second);
        stack.push(first);
        return null;
    }

    @Override
    public IDict<String, Type> typeCheck(IDict<String, Type> typeTable) throws InterpreterException {
        return second.typeCheck(first.typeCheck(typeTable));
    }

    @Override
    public String toString() {
        return String.format("%s;\n%s", first, second);
    }
}
