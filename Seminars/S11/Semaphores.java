import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphores {

    public static void acquireSemaphoreExample(Semaphore semaphore) {
        boolean isAcquired = semaphore.tryAcquire();

        if(isAcquired) {
            System.out.println("Could acquire semaphore - " + Thread.currentThread().getName());
            semaphore.release();
        } else {
            System.out.println("Could not acquire semaphore - " + Thread.currentThread().getName());
        }
    }

    public void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(0);

        Runnable task = () -> acquireSemaphoreExample(semaphore);

        for(int i = 0; i < 20; ++i) {
            executorService.submit(task);
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
