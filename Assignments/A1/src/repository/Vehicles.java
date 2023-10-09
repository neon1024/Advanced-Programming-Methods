package repository;

import model.Vehicle;

public class Vehicles implements Repository {
    private Vehicle[] vehicles;

    private Integer size;

    public Vehicles(Integer capacity) {
        this.size = 0;
        this.vehicles = new Vehicle[capacity];
    }

    @Override
    public void add(Vehicle vehicle) {
        this.vehicles[this.size++] = vehicle;
    }

    @Override
    public void remove() {
        this.vehicles[this.size--] = null;
    }

    public Vehicle[] getAll() {
        return this.vehicles;
    }
}
