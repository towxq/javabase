package 基础知识.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxq
 * @ClassName ThreadTest
 * @Description TODO
 * @date 2021/7/7  19:17
 */
public class ThreadTest {
    static Thread t5 = null;
    static Thread t6 = null;

    public static void main(String[] args) throws InterruptedException {
//        DemoThread demoThread = new DemoThread();
//        DemoThread demoThread1 = new DemoThread();
//        DemoRunable demoRunable = new DemoRunable();
//        Thread thread  = new Thread(demoRunable);
//        Thread thread1  = new Thread(demoRunable);
//        demoThread.start();
//        demoThread1.start();
//        thread.start();
//        thread1.start();

        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();
        Object object = new Object();
        Thread t1 = new Thread(()->{
            synchronized (object){
                for (char c:a1){
                    try {
                        System.out.println(Thread.currentThread().getName()+"--"+c);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        },"t1");


        Thread t2 = new Thread(()->{
            synchronized(object){
                for (char c:a2){
                    try{
                        System.out.println(Thread.currentThread().getName()+"--"+c);
                        object.notify();
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        },"t2");
//        t1.start();
//        t2.start();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread t3 = new Thread(()->{
            try{
                lock.lock();
                for (char c:a1){
                    System.out.println(Thread.currentThread().getName()+"**"+c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t3");


        Thread t4 = new Thread(()->{
            try{
                lock.lock();
                for (char c:a2){
                    System.out.println(Thread.currentThread().getName()+"**"+c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t4");
//        t3.start();
//        t4.start();


         t5 = new Thread(()->{
            for (char c:a1){
                System.out.println(Thread.currentThread().getName()+"**"+c);
                LockSupport.unpark(t6);
                LockSupport.park();
            }
        },"t5");

         t6 = new Thread(()->{
            for (char c:a2){
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"**"+c);
                LockSupport.unpark(t5);
            }
        },"t6");
//         t5.start();
//         t6.start();


        System.out.println("--------main-------");

        Thread thread = new Thread("t1"){
            @Override
            public void run(){
                System.out.println("--------t1-------");
                LockSupport.park();
                System.out.println("--------t2--------");
            }
        };
        thread.start();

        Thread.sleep(5000);
        System.out.println("--------m1--------------");
        LockSupport.unpark(thread);

        System.out.println("--------m2--------------");
        TimeUnit.SECONDS.sleep(10);//线程睡眠
        System.out.println("--------m2--------------");
    }
}


class DemoThread extends Thread{
   private int m =100;
   Object object = new Object();
    public void run(){
        synchronized (object){
            while (true){
                if (m>0){
                    System.out.println(Thread.currentThread().getName()+"---"+m);
                    m--;
                }else{
                    break;
                }
            }
        }
    }
}


class DemoRunable implements Runnable{
    private int m =100;
    Object object = new Object();
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
//        synchronized (object) {
        while (true) {
            try{
                lock.lock();
                    if (m > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "---" + m);
                        m--;
                    } else {
                        break;
                    }
            }finally {
                    lock.unlock();
                }
//            }
        }
    }
}