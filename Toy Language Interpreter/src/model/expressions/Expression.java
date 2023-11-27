package model.expressions;

import exceptions.ExpressionException;
import model.adts.IDictionary;
import model.adts.IHeap;
import model.values.Value;
import model.types.Type;

public interface Expression {

    Value eval(IDictionary<String, Value> symbolTable, IHeap heap) throws ExpressionException;

    Type typeCheck(IDictionary<String, Type> typeEnvironment) throws ExpressionException;

    Expression deepCopy();
}
