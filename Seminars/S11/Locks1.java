import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks1 {
    private void method() {
        synchronized (this) {
            // ...
        }

        // equivalent with
        Lock lock = new ReentrantLock();

        try {
            lock.lock();
            // ...
            method2(lock);

        } finally {
            lock.unlock();
        }
    }

    private void method2(Lock lock) {
    }
}
