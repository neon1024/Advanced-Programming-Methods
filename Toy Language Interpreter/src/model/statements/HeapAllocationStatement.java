package model.statements;

import model.adts.IDictionary;
import model.adts.IHeap;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.Expression;
import model.ProgramState;
import model.types.ReferenceType;
import model.types.Type;
import model.values.ReferenceValue;
import model.values.Value;

public class HeapAllocationStatement implements Statement {
    private final String id;
    private final Expression expression;

    public HeapAllocationStatement(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        IDictionary<String, Value> symbolTable = state.getTableOfSymbols();
        IHeap heap = state.getHeap();

        if (!symbolTable.search(this.id)) {
            throw new StatementException("Variable " + this.id + " is not defined.");
        }
        Value idValue = symbolTable.get(this.id);
        if (!idValue.getType().equals(new ReferenceType(null))) {
            throw new StatementException("Variable " + this.id + " is not a reference type.");
        }

        try {
            Value expressionValue = this.expression.eval(symbolTable, heap);
            ReferenceValue referenceValue = (ReferenceValue) idValue;
            if (!expressionValue.getType().equals(referenceValue.getLocationType())) {
                throw new StatementException("Declared type of variable " + this.id +
                        " and type of the assigned expression do not match.");
            }

            int id = heap.add(expressionValue);
            symbolTable.update(this.id, new ReferenceValue(id, expressionValue.getType()));
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }

        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        try {
            Type typeVariable = typeEnvironment.get(this.id);
            Type typeExpression = this.expression.typeCheck(typeEnvironment);
            if (!typeVariable.equals(new ReferenceType(typeExpression))) {
                throw new StatementException("Declared type of variable " + this.id +
                        " and type of the assigned expression do not match.");
            }
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }
        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new HeapAllocationStatement(this.id, this.expression.deepCopy());
    }

    public String toString() {
        return "new(" + this.id + ", " + this.expression.toString() + ")";
    }
}
