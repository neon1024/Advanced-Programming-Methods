package model.statements;

import model.adts.IDictionary;
import exceptions.StatementException;
import model.ProgramState;
import model.types.Type;
import model.values.Value;


public class VarDecStatement implements Statement {
    String id;
    Type type;

    public VarDecStatement(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        IDictionary<String, Value> tableOfSymbols = state.getTableOfSymbols();

        if (tableOfSymbols.search(this.id)) {
            throw new StatementException("Variable " + this.id + " is already defined.");
        } else {
            tableOfSymbols.add(this.id, this.type.defaultValue());
        }

        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnvironment) throws StatementException {
        typeEnvironment.add(this.id, this.type);
        return typeEnvironment;
    }

    @Override
    public Statement deepCopy() {
        return new VarDecStatement(this.id, this.type.deepCopy());
    }

    public String toString() {
        return this.type + " " + this.id;
    }
}
