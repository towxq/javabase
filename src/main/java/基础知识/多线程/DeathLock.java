package 基础知识.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @author wxq
 * @ClassName DeathLock
 * @Description TODO
 * @date 2021/7/13  15:27
 */
public class DeathLock {
    public static void main(String[] args) {
        new Thread(new DeathLockDemo1()).start();
        new Thread(new DeathLockDemo2()).start();
    }
}

class DeathLockDemo1 implements Runnable{

    @Override
    public void run() {
        synchronized (DeathLockDemo1.class){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取lock1");
            synchronized (DeathLockDemo2.class){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获取lock2");
            }
        }
    }
}

class DeathLockDemo2 implements Runnable{

    @Override
    public void run() {
        synchronized (DeathLockDemo2.class){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取lock2");
            synchronized (DeathLockDemo1.class){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获取lock1");
            }
        }
    }
}
