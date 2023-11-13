package model.values;

import model.types.IntType;
import model.types.Type;

public class IntValue implements Value {

    public final int value;

    public IntValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public String toString() {
        return String.format("%d", this.value);
    }

    @Override
    public boolean equals(Object object) {
        if(! (object instanceof IntValue)) return false;

        IntValue castedObject = (IntValue) object;

        return this.value == castedObject.value;
    }
}
