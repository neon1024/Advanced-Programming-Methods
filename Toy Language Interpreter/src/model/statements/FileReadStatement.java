package model.statements;

import model.adts.IDictionary;
import model.adts.IHeap;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.Expression;
import model.ProgramState;
import model.types.IntType;
import model.types.StringType;
import model.types.Type;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReadStatement implements Statement {

    private final Expression expression;
    private final String id;

    public FileReadStatement(Expression expression, String id) {
        this.expression = expression;
        this.id = id;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        IDictionary<String, Value> tableOfSymbols = programState.getTableOfSymbols();
        IDictionary<String, BufferedReader> fileTable = programState.getFileTable();
        IHeap heap = programState.getHeap();

        if (!tableOfSymbols.search(this.id)) {
            throw new StatementException("Variable " + this.id + " is not defined.");
        }

        Value idValue = tableOfSymbols.get(this.id);

        if (!idValue.getType().equals(new IntType())) {
            throw new StatementException("Variable " + this.id + " is not of type int.");
        }

        try {
            Value expressionValue = this.expression.eval(tableOfSymbols, heap);

            if (!expressionValue.getType().equals(new StringType())) {
                throw new StatementException("Expression " + this.expression + " is not of type string.");
            }

            StringValue stringValue = (StringValue) expressionValue;

            if (!fileTable.search(stringValue.getValue())) {
                throw new StatementException("File " + stringValue.getValue() + " not opened.");
            }

            BufferedReader bufferedReader = fileTable.get(stringValue.getValue());
            String line = bufferedReader.readLine();

            if (line == null) {
                IntType intType = new IntType();
                tableOfSymbols.update(this.id, intType.defaultValue());
            } else {
                tableOfSymbols.update(this.id, new IntValue(Integer.parseInt(line)));
            }

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
            Type idType = typeEnvironment.get(this.id);
            if (!idType.equals(new IntType())) {
                throw new StatementException("Variable " + this.id + " is not of type int.");
            }
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }

        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new FileReadStatement(this.expression.deepCopy(), this.id);
    }

    public String toString() {
        return "readFile(" + this.expression + ", " + this.id + ")";
    }
}
