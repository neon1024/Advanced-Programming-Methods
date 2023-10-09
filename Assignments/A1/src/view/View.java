package view;

import controller.Controller;
import model.Vehicle;

public class View {
    Controller controller = null;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void show() {
        Vehicle[] vehicles = this.controller.getAll();

        int index = 0;

        while(vehicles[index] != null) {
            System.out.println(vehicles[index++]);
        }
    }
}
