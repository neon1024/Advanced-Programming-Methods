package model.expressions;

import exceptions.InterpreterException;
import model.adt.IDict;
import model.types.IntType;
import model.types.Type;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

public class LogicExpression implements Expression {

    private Expression first;

    private int operation;

    private Expression second;

    public LogicExpression(Expression first, int operation, Expression second) {
        this.first = first;
        this.operation = operation;
        this.second = second;
    }

    @Override
    public Value evaluate(IDict<String, Value> symbolTable) throws InterpreterException {
        Value firstValue = first.evaluate(symbolTable);
        Value secondValue = second.evaluate(symbolTable);

        if(firstValue.getType() instanceof IntType || secondValue instanceof IntType) throw new InterpreterException("Different types");

        BoolValue firstBoolean = (BoolValue) firstValue;
        BoolValue secondBoolean = (BoolValue) secondValue;

        if(operation == 1)
            return new BoolValue(firstBoolean.getValue() && secondBoolean.getValue());

        if(operation == 2)
            return new BoolValue(firstBoolean.getValue() || secondBoolean.getValue());

        throw new InterpreterException("Unknown operation");
    }

    @Override
    public String toString() {
        return first.toString() + " " + (operation == 1 ? "and" : "or") + " " + second.toString();
    }
}
