package model.statements;

import model.adts.IDictionary;
import model.adts.IHeap;
import model.adts.IList;
import exceptions.*;
import model.expressions.Expression;
import model.ProgramState;
import model.statements.Statement;
import model.types.Type;
import model.values.Value;

public class PrintStatement implements Statement {

    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        IDictionary<String, Value> tableOfSymbols = programState.getTableOfSymbols();
        IList<Value> output = programState.getOutput();
        IHeap heap = programState.getHeap();

        try {
            Value value = this.expression.eval(tableOfSymbols, heap);
            output.pushBack(value);
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }

        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        try {
            this.expression.typeCheck(typeEnvironment);
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }
        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new PrintStatement(this.expression.deepCopy());
    }

    public String toString() {
        return "print(" + this.expression + ")";
    }
}
