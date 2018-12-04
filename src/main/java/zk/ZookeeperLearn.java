package zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperLearn {
    private static String connectString="ip:2181,ip2:2181,ip3:2181";
    private static ZooKeeper zooKeeperCli;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException, KeeperException {

        connect();
        create();
        exits();
        countDownLatch.await();
        close();
    }

    private static void exits() throws KeeperException, InterruptedException {
        Stat exists = zooKeeperCli.exists("/sanguo/shuguo", false);

        byte[] data = zooKeeperCli.getData("/sanguo", false, exists);

        Stat stat = zooKeeperCli.setData("/sanguo/weiguo", "君主是曹操".getBytes(), 1);
    }

    private static void close() {
        if(zooKeeperCli!=null){
            try {
                zooKeeperCli.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static ZooKeeper connect() {
        try {
            zooKeeperCli = new ZooKeeper(connectString, 2000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("回调了watch机制");
                    countDownLatch.countDown();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zooKeeperCli;
    }

    /**
     * 创建节点
     */
    private static void create(){
        try {
            String result=zooKeeperCli.create("/sanguo/shuguo","君主的刘备".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
