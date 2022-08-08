package 基础知识.多线程;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wxq
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @date 2021/7/10  23:46
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获得
                    System.out.println(Thread.currentThread().getName()+"进入");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"出来");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
            },String.valueOf(i)).start();
        }
    }
}
