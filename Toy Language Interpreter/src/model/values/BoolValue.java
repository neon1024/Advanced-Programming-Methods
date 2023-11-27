package model.values;

import model.types.BoolType;
import model.types.Type;

public class BoolValue implements Value {

    private final boolean value;

    public BoolValue(boolean value) {
        this.value = value;
    }

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        if(anotherObject instanceof BoolValue) {
            return ((BoolValue) anotherObject).getValue() == this.value;
        }

        return false;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    public boolean getValue() { return this.value; }

    @Override
    public Value deepCopy() {
        return new BoolValue(this.value);
    }

    public String toString() { return Boolean.toString(this.value); }
}
