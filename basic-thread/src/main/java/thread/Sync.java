package thread;

public class Sync {

    Object o;

    public Sync(Object o) {
        this.o = o;
    }

    void w() {
        synchronized (o) {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.holdsLock(o));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        Sync s = new Sync(o);

        System.out.println(Thread.currentThread().getName() + ", " + Thread.holdsLock(o));

        new Thread(() -> {
            s.w();
        }).start();

        new Thread(() -> {
            s.w();
        }).start();
    }

}
