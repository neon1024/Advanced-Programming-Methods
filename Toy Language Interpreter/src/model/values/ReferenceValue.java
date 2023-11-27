package model.values;

import model.types.ReferenceType;
import model.types.Type;

public class ReferenceValue implements Value {

    private final int address;
    private final Type locationType;

    public ReferenceValue(int address, Type locationType) {
        this.address = address;
        this.locationType = locationType;
    }

    public int getAddress() {
        return this.address;
    }

    public Type getLocationType() {
        return this.locationType;
    }

    public boolean equals(Object anotherObject) {
        if(anotherObject == null) return false;

        if(anotherObject == this) return true;

        if(anotherObject instanceof ReferenceValue) {
            return ((ReferenceValue) anotherObject).getAddress() == this.address &&
                    ((ReferenceValue) anotherObject).getLocationType() == this.locationType;
        }

        return false;
    }

    @Override
    public Type getType() {
        return new ReferenceType(this.locationType);
    }

    @Override
    public Value deepCopy() {
        return new ReferenceValue(this.address, this.locationType.deepCopy());
    }

    public String toString() {
        return "(" + this.address + ", " + this.locationType + ")";
    }
}
