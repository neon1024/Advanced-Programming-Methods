package repository;

import model.Vehicle;

public interface Repository {
    public void add(Vehicle vehicle);

    public void remove();

    public Vehicle[] getAll();
}
