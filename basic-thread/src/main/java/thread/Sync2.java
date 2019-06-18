package thread;

public class Sync2 {
    public void s1() {
        synchronized (this) {
            System.out.println("s1");
        }
    }

    public static void s2() {
        synchronized (Sync2.class) {
            System.out.println("s2");
        }
    }

}