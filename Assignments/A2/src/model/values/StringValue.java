package model.values;

import model.types.StringType;
import model.types.Type;

public class StringValue implements Value{
    private final String val;

    public StringValue(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    @Override
    public Type getType() {
        return new StringType();
    }

    @Override
    public String toString() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StringValue))
            return false;
        StringValue castObj = (StringValue)obj;
        return val.equals(castObj.val);
    }
}
