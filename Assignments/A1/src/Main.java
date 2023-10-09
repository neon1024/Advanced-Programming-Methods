/*
3. Intr-un service se afla in reparatie mai multe
masini, camioane si motociclete. Sa se afiseze
toate autovehiculele ce au costul de reparatie
mai mare de 1000Ron.
 */

import controller.Controller;
import repository.Repository;
import repository.Vehicles;
import model.Car;
import model.Truck;
import model.Motorbike;
import view.View;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Vehicles(10);
        Controller controller = new Controller(repository);
        View view = new View(controller);

        controller.add(new Car(100));
        controller.add(new Truck(200));
        controller.add(new Motorbike(300));
        controller.add(new Car(1000));
        controller.add(new Truck(10000));
        controller.add(new Motorbike(10000));

        view.show();
    }
}
