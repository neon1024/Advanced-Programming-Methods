package view.gui.tableEntry;

import javafx.beans.property.SimpleStringProperty;
import model.values.Value;

public class HeapTableEntry {
    private final int address;
    private final Value value;

    public HeapTableEntry(int address, Value value) {
        this.address = address;
        this.value = value;
    }

    public int getAddress() {
        return this.address;
    }

    public Value getValue() {
        return this.value;
    }

    public SimpleStringProperty addressProperty() {
        return new SimpleStringProperty(String.valueOf(this.address));
    }

    public SimpleStringProperty valueProperty() {
        return new SimpleStringProperty(this.value.toString());
    }
}
