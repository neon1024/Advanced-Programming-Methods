package model;

public class Vehicle {
    private Integer repairCost;
    private String type;

    public Vehicle(Integer repairCost, String type) {
        this.repairCost = repairCost;
        this.type = type;
    }

    public void setRepairCost(Integer repairCost) {
        this.repairCost = repairCost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRepairCost() {
        return this.repairCost;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type + ": " + this.repairCost.toString() + '\n';
    }
}
