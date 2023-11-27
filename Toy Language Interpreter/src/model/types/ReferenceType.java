package model.types;

import model.values.ReferenceValue;
import model.values.Value;

public class ReferenceType implements Type {

    private final Type locationType;

    public ReferenceType(Type locationType) {
        this.locationType = locationType;
    }

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        return anotherObject instanceof ReferenceType;
    }


    @Override
    public Value defaultValue() {
        return new ReferenceValue(0, this.locationType);
    }

    @Override
    public Type deepCopy() {
        return new ReferenceType(this.locationType);
    }
}
