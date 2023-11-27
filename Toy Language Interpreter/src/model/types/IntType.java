package model.types;

import model.values.IntValue;
import model.values.Value;

public class IntType implements Type {
    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        return anotherObject instanceof IntType;
    }

    @Override
    public Value defaultValue() {
        return new IntValue(0);
    }

    @Override
    public Type deepCopy() {
        return new IntType();
    }

    public String toString() {
        return "int";
    }
}
