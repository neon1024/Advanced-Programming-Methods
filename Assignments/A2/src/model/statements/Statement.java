package model.statements;

import exceptions.DictionaryException;
import exceptions.InterpreterException;
import exceptions.StatementException;
import model.ProgramState;
import model.adt.IDict;
import model.types.Type;

public interface Statement {
    ProgramState execute(ProgramState state) throws StatementException, DictionaryException, InterpreterException;
}
