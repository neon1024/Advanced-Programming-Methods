package model.expressions;

import model.adts.IDictionary;
import model.adts.IHeap;
import exceptions.ExpressionException;
import model.types.Type;
import model.values.Value;

public class VarNameExpression implements Expression {
    String id;

    public VarNameExpression(String id) {
        this.id = id;
    }

    @Override
    public Value eval(IDictionary<String, Value> symbolTable, IHeap heap) throws ExpressionException {
        return symbolTable.get(this.id);
    }

    @Override
    public Type typeCheck(IDictionary<String, Type> typeEnvironment) throws ExpressionException {
        return typeEnvironment.get(this.id);
    }

    @Override
    public Expression deepCopy() {
        return new VarNameExpression(this.id);
    }

    public String toString() {
        return this.id;
    }
}
