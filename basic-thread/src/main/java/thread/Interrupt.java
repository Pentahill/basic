package thread;

import java.util.concurrent.CountDownLatch;

public class Interrupt {


    public synchronized void syn() throws InterruptedException {
        System.out.println("begin wait");
        wait();
    }

    public static void main(String[] args) throws InterruptedException {
        Interrupt interrupt = new Interrupt();
        CountDownLatch c = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            try {
                c.countDown();
                interrupt.syn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        c.await();
        t1.interrupt();
    }

}
