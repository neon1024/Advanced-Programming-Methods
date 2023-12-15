import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock2 {
    Lock instanceLock = new ReentrantLock();

    private void method1() {
        try {
            instanceLock.lock();
            // ...

            method2();

        } finally {
            instanceLock.unlock();
        }
    }

    private void method2() {
        try {
            instanceLock.lock();
            // ...

        } finally {
            instanceLock.unlock();
        }
    }
}
