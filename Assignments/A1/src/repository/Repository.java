package repository;

import model.Vehicle;

public interface Repository {
    public void add(Vehicle vehicle) throws MaxSizeReachedException;

    public void remove() throws MinSizeReachedException;

    public Vehicle[] getAll();
}
