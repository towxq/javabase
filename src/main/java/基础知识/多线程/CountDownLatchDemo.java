package 基础知识.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author wxq
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @date 2021/7/10  23:45
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"run.....");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("stop................");
    }
}
