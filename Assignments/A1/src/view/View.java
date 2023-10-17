package view;

import controller.Controller;
import model.Car;
import model.Motorbike;
import model.Truck;
import model.Vehicle;
import repository.MaxSizeReachedException;
import repository.MinSizeReachedException;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Controller controller = null;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void menu() {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                this.show_menu_options();

                var option = scanner.next();

                switch (option) {
                    case "1":
                        this.add();
                        break;

                    case "2":
                        this.remove();
                        break;

                    case "3":
                        this.show();
                        break;

                    case "4":
                        this.show_filtered();
                        break;

                    case "x":
                        System.exit(0);

                    default:
                        return;
                }
            }
        } catch (MinSizeReachedException | MaxSizeReachedException msre) {
            System.err.println(msre.getMessage());
        }
    }

    private void show_menu_options() {
        System.out.println("1: add");
        System.out.println("2: remove");
        System.out.println("3: show all cars");
        System.out.println("4: show cars with repair cost > 1000");
        System.out.println("x: exit");
    }

    private void add() throws MaxSizeReachedException {
        System.out.println("1: Car");
        System.out.println("2: Truck");
        System.out.println("3: Motorbike");

        Scanner scanner = new Scanner(System.in);

        var option = scanner.next();

        System.out.println("repair cost: ");

        int repairCost = scanner.nextInt();

        switch (option) {
            case "1":
                // add Car
                this.controller.add(new Car(repairCost));
                break;

            case "2":
                // add Truck
                this.controller.add(new Truck(repairCost));
                break;

            case "3":
                // add Motorbike
                this.controller.add(new Motorbike(repairCost));
                break;
        }
    }

    private void remove() throws MinSizeReachedException {
        this.controller.remove();
    }

    public void show() {
        ArrayList<Vehicle> vehicles = this.controller.getAll();

        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void show_filtered() {
        ArrayList<Vehicle> vehicles = this.controller.filterByRepairCost();

        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle);
        }
    }
}
