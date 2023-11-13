package model.expressions;

import exceptions.InterpreterException;
import model.adt.IDict;
import model.values.Value;

public interface Expression {
    Value evaluate(IDict<String, Value> symbolTable) throws InterpreterException;
}
