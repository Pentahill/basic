package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile {

    static final int N = 10000;

    public volatile int counter = 0;
//    public AtomicInteger counter = new AtomicInteger(0);

    public void add() {
        counter++;
//        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        Volatile v = new Volatile();

        new Thread(() -> {
            for(int i = 0; i < N; i++) {
                v.add();
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for(int i = 0; i < N; i++) {
                v.add();
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for(int i = 0; i < N; i++) {
                v.add();
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for(int i = 0; i < N; i++) {
                v.add();
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for(int i = 0; i < N; i++) {
                v.add();
            }
            cdl.countDown();
        }).start();

        cdl.await();
        System.out.println(v.counter);
//        System.out.println(v.counter.get());
    }

}
