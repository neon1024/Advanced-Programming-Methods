package model.values;

import model.types.StringType;
import model.types.Type;

public class StringValue implements Value {

    private final String value;

    public StringValue(String value) {
        this.value = value;
    }

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        if(anotherObject instanceof StringValue) {
            return ((StringValue) anotherObject).getValue() == this.value;
        }

        return false;
    }

    @Override
    public Type getType() {
        return new StringType();
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public Value deepCopy() {
        return new StringValue(this.value);
    }
}
