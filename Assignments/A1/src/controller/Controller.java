package controller;

import model.Vehicle;
import repository.MaxSizeReachedException;
import repository.MinSizeReachedException;
import repository.Repository;

import java.util.ArrayList;

public class Controller {
    Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void add(Vehicle vehicle) throws MaxSizeReachedException {
        this.repository.add(vehicle);
    }

    public void remove() throws MinSizeReachedException {
        this.repository.remove();
    }

    public ArrayList<Vehicle> getAll() {
        Vehicle[] vehicles = this.repository.getAll();

        ArrayList<Vehicle> nonNullVehicles = new ArrayList<>();

        for(Vehicle vehicle: vehicles) {
            if(vehicle != null) {
                nonNullVehicles.add(vehicle);
            }
        }

        return nonNullVehicles;
    }

    public ArrayList<Vehicle> filterByRepairCost() {
        Vehicle[] allVehicles = this.repository.getAll();

        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        for(Vehicle vehicle: allVehicles) {
            if(vehicle != null && vehicle.getRepairCost() > 1000) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }
}
