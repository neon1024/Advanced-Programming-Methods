package model.statements;

import exceptions.InterpreterException;
import model.ProgramState;
import model.adt.IDict;
import model.adt.IStack;
import model.expressions.Expression;
import model.values.Value;

public class AssignmentStatement implements Statement {
    private final String key;
    private final Expression expression;

    public AssignmentStatement(String key, Expression expression) {
        this.key = key;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws InterpreterException {
        IStack<Statement> stack = state.getExecutionStack();
        IDict<String, Value> tableOfSymbols = state.getSymTable();

        if(tableOfSymbols.containsKey(key)) {
            Value value = this.expression.evaluate(tableOfSymbols);

        }

        return state;
    }

    @Override
    public String toString() {
        return String.format("Assignment{%s = %s}", key, expression);
    }
}
