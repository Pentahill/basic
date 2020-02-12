package boot.watch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class CommonWatch {

    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("10.0.2.15:3000", 2000, null);
            zk.getChildren("/emptest", false);

            Thread.sleep(300000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

}
