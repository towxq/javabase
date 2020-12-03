package 分布式;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooKeeper;

public class zookeeperdemo {

    /** zookeeper地址 */
    static final String CONNECT_ADDR = "192.168.11.130:2181";
    /** session超时时间 */
    static final int SESSION_OUTTIME = 5000;//ms

    public static void main(String[] args) {

        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        //2 通过工厂创建连接
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString("192.168.11.130:2181")
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
//              .namespace("super")
                .build();
        //3 开启连接
        cf.start();

        System.out.println(ZooKeeper.States.CONNECTED);
        System.out.println(cf.getState());

    }
}
