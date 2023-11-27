package model.types;

import model.values.Value;
import model.values.BoolValue;

public class BoolType implements Type {

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        return anotherObject instanceof BoolType;
    }

    @Override
    public Value defaultValue() {
        return new BoolValue(false);
    }

    @Override
    public Type deepCopy() {
        return new BoolType();
    }

    public String toString() {
        return "bool";
    }
}
