package model.types;

import model.values.FloatValue;
import model.values.Value;

public class FloatType implements Type {

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        return anotherObject instanceof FloatType;
    }

    @Override
    public Value defaultValue() {
        return new FloatValue(.0f);
    }

    @Override
    public Type deepCopy() {
        return new FloatType();
    }

    public String toString() {
        return "float";
    }
}
