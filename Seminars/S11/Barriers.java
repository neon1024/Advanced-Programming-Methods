import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Barriers {

    public static void worker(CyclicBarrier barrier) {
        takeOutAnimals();
        barrier.await();
        cleanCage();
        barrier.await();
        getBackAnimals();
        barrier.await();
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("Barrier is reset");
        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 4; ++i) {
            executorService.submit(() -> worker(barrier));
        }
    }
}
