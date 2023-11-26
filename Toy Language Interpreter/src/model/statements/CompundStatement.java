package model.statements;

import exceptions.StatementException;
import model.ProgramState;

public class CompundStatement implements Statement {

    Statement first;
    Statement second;

    @Override
    public ProgramState execute(ProgramState programState) throws StatementException {
        // TODO

        return null;
    }

    public String toString() {
        return "(" + this.first.toString() + ";" + this.second.toString() + ")";
    }
}
