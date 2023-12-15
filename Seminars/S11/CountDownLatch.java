import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDownLatch {

    static class Service extends Thread {
        CountDownLatch latch;

        int duration;

        Service(CountDownLatch latch, int duration) {
            this.latch = latch;
            this.duration = duration;
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);

        Thread service1 = new Service(latch, 1000);
        Thread service2 = new Service(latch, 2000);
        Thread service3 = new Service(latch, 3000);
        Thread service4 = new Service(latch, 4000);

        service1.start();
        service2.start();
        service3.start();
        service4.start();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Object> objects = new ArrayList<>(Arrays.asList(1, "number", 2, "string", 4, 5));

        List<Object> result = objects.stream().filter((int number, String string) -> number + string));

    }
}
