package thread;

import java.util.concurrent.CountDownLatch;

public class Syn3 {
    final String[] strs = {"a", "b", "c"};
    final int[] ints = {1, 2, 3};

    public synchronized void strPrint() throws InterruptedException {
        for(String s : strs) {
            System.out.print(s);
            notify();
            wait();
        }
    }

    public synchronized void intPrint() throws InterruptedException {
        for(int i : ints) {
            System.out.print(i);
            notify();
            wait();
        }
    }

    public static void main(String[] args) {
        Syn3 s3 = new Syn3();

        new Thread(() -> {
            try {
                s3.strPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                s3.intPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
