package model.statements;

import exceptions.InterpreterException;
import model.ProgramState;
import model.expressions.Expression;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.Value;

public class IfStatement implements Statement {
    private final Expression exp;
    private final Statement first;
    private final Statement second;

    public IfStatement(Expression _exp, Statement _first, Statement _second) {
        exp = _exp;
        first = _first;
        second = _second;
    }

    @Override
    public ProgramState execute(ProgramState state) throws InterpreterException {
        Value value = exp.evaluate(state.getSymTable());
        if (value.getType().equals(new BoolType())) {
            BoolValue condition = (BoolValue)value;
            if (condition.getValue())
                state.getExecutionStack().push(first);
            else state.getExecutionStack().push(second);
            return null;
        }
        throw new InterpreterException(String.format("ERROR: %s not of type bool inside if", value.toString()));
    }

    @Override
    public String toString() {
        return String.format("if(%s){\n\t%s\n}else{\n\t%s\n}", exp.toString(), first.toString(), second.toString());
    }
}
