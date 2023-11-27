package model.statements;

import model.adts.IDictionary;
import model.ProgramState;
import model.types.Type;

public class NOPStatement implements Statement {

    @Override
    public ProgramState execute(ProgramState state) {
        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) {
        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new NOPStatement();
    }

    public String toString() {
        return "nop";
    }
}
