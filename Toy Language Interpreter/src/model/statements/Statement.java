package model.statements;

import exceptions.StatementException;
import model.ProgramState;
import model.adts.IDictionary;
import model.types.Type;

public interface Statement {

    ProgramState execute(ProgramState programState) throws StatementException;

    IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException;

    Statement deepCopy();
}
