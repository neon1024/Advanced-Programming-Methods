/*
3. Intr-un service se afla in reparatie mai multe
masini, camioane si motociclete. Sa se afiseze
toate autovehiculele ce au costul de reparatie
mai mare de 1000Ron.
 */

import repository.Repository;
import repository.InMemoryRepository;
import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        Repository repository = new InMemoryRepository(10);
        Controller controller = new Controller(repository);
        View view = new View(controller);

        view.menu();
    }
}
