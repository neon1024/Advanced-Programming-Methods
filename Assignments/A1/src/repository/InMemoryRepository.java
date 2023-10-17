package repository;

import model.Vehicle;

public class InMemoryRepository implements Repository {
    private Vehicle[] vehicles;

    private int size;

    public InMemoryRepository(int capacity) {
        this.size = 0;
        this.vehicles = new Vehicle[capacity];
    }

    @Override
    public void add(Vehicle vehicle) throws MaxSizeReachedException {
        if (this.size < this.vehicles.length) {
            this.vehicles[this.size++] = vehicle;
        } else {
            throw new MaxSizeReachedException();
        }
    }

    @Override
    public void remove() throws MinSizeReachedException {
        if (this.size > 0) {
            this.vehicles[--this.size] = null;
        } else {
            throw new MinSizeReachedException();
        }
    }

    public Vehicle[] getAll() {
        return this.vehicles;
    }
}
