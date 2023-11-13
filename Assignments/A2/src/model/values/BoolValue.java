package model.values;

import model.types.BoolType;
import model.types.Type;

public class BoolValue implements Value {

    private final boolean value;

    public BoolValue(boolean defaultValue) {
        this.value = defaultValue;
    }
    @Override
    public Type getType() {
        return new BoolType();
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value ? "true" : "false";
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof BoolValue)) return false;

        BoolValue castedObject = (BoolValue)object;

        return this.value == castedObject.value;
    }
}
