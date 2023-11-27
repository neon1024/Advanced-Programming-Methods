package model.values;

import model.types.IntType;
import model.types.Type;

public class IntValue implements Value {
    private final int value;

    public IntValue(int value) {
        this.value = value;
    }

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        if(anotherObject instanceof IntValue) {
            return ((IntValue) anotherObject).getValue() == this.value;
        }

        return false;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public Value deepCopy() {
        return new IntValue(this.value);
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
