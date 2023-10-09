package controller;

import model.Vehicle;
import repository.Repository;

public class Controller {
    Repository repository = null;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void add(Vehicle vehicle) {
        this.repository.add(vehicle);
    }

    public void remove() {
        this.repository.remove();
    }

    public Vehicle[] getAll() { return this.repository.getAll(); }
}
