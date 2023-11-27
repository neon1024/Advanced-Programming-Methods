package model.expressions;

import model.adts.IDictionary;
import model.adts.IHeap;
import model.types.Type;
import model.values.Value;

public class ValueExpression implements Expression {
    private final Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    @Override
    public Value eval(IDictionary<String, Value> symbolTable, IHeap heap) {
        return this.value;
    }

    @Override
    public Type typeCheck(IDictionary<String, Type> typeEnvironment) {
        return this.value.getType();
    }

    @Override
    public Expression deepCopy() {
        return new ValueExpression(this.value.deepCopy());
    }

    public String toString() {
        return this.value.toString();
    }
}
