package model.statements;

import model.adts.IDictionary;
import model.adts.IHeap;
import model.adts.IStack;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.Expression;
import model.ProgramState;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;
import model.values.Value;

public class WhileStatement implements Statement {
    private final Expression expression;
    private final Statement statement;

    public WhileStatement(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        IStack<Statement> executionStack = state.getExecutionStack();
        IDictionary<String, Value> tableOfSymbols = state.getTableOfSymbols();
        IHeap heap = state.getHeap();

        try {
            Value value = this.expression.eval(tableOfSymbols, heap);
            if (!value.getType().equals(new BoolType())) {
                throw new StatementException("Expression " + this.expression + " is not a boolean");
            }
            
            BoolValue boolValue = (BoolValue) value;
            
            if (boolValue.getValue()) {
                executionStack.push(this);
                executionStack.push(this.statement);
            }
            
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }

        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        try {
            Type expressionType = this.expression.typeCheck(typeEnvironment);
            if (!expressionType.equals(new BoolType())) {
                throw new StatementException("Expression " + this.expression + " is not a boolean");
            }
            this.statement.typeCheck(typeEnvironment.deepCopy());
        } catch (ExpressionException e) {
            throw new StatementException(e.getMessage());
        }
        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new WhileStatement(this.expression.deepCopy(), this.statement.deepCopy());
    }

    public String toString() {
        return "while (" + this.expression.toString() + ") " + this.statement;
    }
}
