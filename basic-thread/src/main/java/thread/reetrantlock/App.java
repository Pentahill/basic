package thread.reetrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    final Lock lock = new ReentrantLock();

    final Condition reachThreeCondition = lock.newCondition();
    final Condition reachSixCondition = lock.newCondition();

    int num = 0;

    public void three() {
        try {
            lock.lock();

            while(num <= 3) {
                System.out.println(num);
                num++;
            }

            reachThreeCondition.signal();
        } finally {
            lock.unlock();
        }

        try {
            lock.lock();

            reachSixCondition.await();
            while(num <= 9) {
                System.out.println(num);
                num++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void six() {
        try {
            lock.lock();

            while(num <= 3) {
                reachThreeCondition.await();
            }

            while(num <= 6) {
                System.out.println(num);
                num++;
            }

            reachSixCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        App app = new App();

        new Thread(() -> {
            System.out.println("threadA is start");
            app.three();
        }).start();

        new Thread(() -> {
            System.out.println("threadB is start");
            app.six();
        }).start();
    }
}
