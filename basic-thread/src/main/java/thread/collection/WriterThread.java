package thread.collection;

import java.util.List;

public class WriterThread extends Thread {

    private final List<Integer> list;

    public WriterThread(List<Integer> list) {
        super("WriterThead");
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; true; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}
