package model.statements;

import exceptions.StatementException;
import model.ProgramState;
import model.expressions.Expression;

public class AssignmentStatement implements Statement {

    String id;
    Expression expression;

    public AssignmentStatement(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        // TODO

        return programState;
    }

    public String toString() {
        return id + " = " + this.expression.toString();
    }
}
