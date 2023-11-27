package model.statements;

import model.adts.IDictionary;
import model.adts.IHeap;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.Expression;
import model.ProgramState;
import model.types.StringType;
import model.types.Type;
import model.values.StringValue;
import model.values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseFileReadStatement implements Statement {
    private final Expression expression;

    public CloseFileReadStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        IDictionary<String, Value> tableOfSymbols = programState.getTableOfSymbols();
        IDictionary<String, BufferedReader> fileTable = programState.getFileTable();
        IHeap heap = programState.getHeap();

        try {
            Value value = this.expression.eval(tableOfSymbols, heap);

            if (!value.getType().equals(new StringType())) {
                throw new StatementException("Expression " + this.expression + " is not of type string.");
            }

            StringValue stringValue = (StringValue) value;

            if (!fileTable.search(stringValue.getValue())) {
                throw new StatementException("File " + stringValue.getValue() + " not opened.");
            }

            BufferedReader bufferedReader = fileTable.get(stringValue.getValue());
            bufferedReader.close();
            fileTable.remove(stringValue.getValue());

        } catch (ExpressionException | IOException e) {
            throw new StatementException(e.getMessage());
        }

        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        try {
            Type expressionType = this.expression.typeCheck(typeEnvironment);

            if (!expressionType.equals(new StringType())) {
                throw new StatementException("Expression " + this.expression + " is not of type string.");
            }

        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }

        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new CloseFileReadStatement(this.expression.deepCopy());
    }

    public String toString() {
        return "closeRFile(" + this.expression + ")";
    }
}
