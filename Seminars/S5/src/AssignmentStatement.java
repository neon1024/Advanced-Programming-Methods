import java.beans.Expression;

public class AssignmentStatement implements IStatement {
    Expression expression;

    public AssignmentStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public IStatement deepcopy() {
        return new AssignmentStatement(expression.deepcopy());
    }
}
