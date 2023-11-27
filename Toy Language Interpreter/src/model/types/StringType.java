package model.types;

import model.values.StringValue;
import model.values.Value;

public class StringType implements Type {

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        return anotherObject instanceof StringType;
    }

    @Override
    public Value defaultValue() {
        return new StringValue("");
    }

    @Override
    public Type deepCopy() {
        return new StringType();
    }

    public String toString() {
        return "string";
    }
}
