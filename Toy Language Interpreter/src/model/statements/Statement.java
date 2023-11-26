package model.statements;

import exceptions.StatementException;
import model.ProgramState;

public interface Statement {

    ProgramState execute(ProgramState programState) throws StatementException;
}
