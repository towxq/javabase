package 基础知识.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class  LockDemo
{
    public static void main(String[] args) throws InterruptedException {
        Myservice myservice = new Myservice();
//        MyThreadTest m1 = new MyThreadTest(myservice);
//        MyThreadTest m2 = new MyThreadTest(myservice);
//        MyThreadTest m3 = new MyThreadTest(myservice);
//        MyThreadTest m4 = new MyThreadTest(myservice);
//        MyThreadTest m5 = new MyThreadTest(myservice);
//
//
//        m1.start();
//        m2.start();
//        m3.start();
//        m4.start();
//        m5.start();

        MyThreadTest a = new MyThreadTest(myservice);
        a.start();
        Thread.sleep(3000);
        myservice.signal();


    }

}
class Myservice{
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

//    public void testMethod(){
//        lock.lock();
//        try{
//            for (int i =0;i<5;i++){
//                System.out.println("ThreadName="+Thread.currentThread());
//            }
//        }finally {
//            lock.unlock();
//        }
//    }

    public void await(){
        lock.lock();
        try{
            System.out.println("await时间为"+System.currentTimeMillis());
            condition.await();
            System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("signal时间为"+System.currentTimeMillis());
            condition.signal();
            Thread.sleep(3000);
            System.out.println("这是condition.signal()方法之后的语句");
        }finally{
            lock.unlock();
        }

    }

}
class MyThreadTest extends Thread{
    private Myservice myservice;

    public MyThreadTest(Myservice myservice){
        this.myservice = myservice;
    }

    public void run(){
//        myservice.testMethod();
          myservice.await();
    }
}
//synchronized关键字的缺陷
//    1，无法控制阻塞时长
//    2，阻塞不能被中断



//synchronized不需要用户手动释放锁，当synchronized方法或者代码块执行后，系统会自动让线程释放锁，而Lock需要用户自己释放锁
//没有释放会导致死锁的现象

//Lock接口提供的synchronized关键字不具备的特性
//    尝试非阻塞的获取锁   当前线程尝试获取锁，如果这一时刻锁没有其他线程获取到，则成功获取并持有锁
//
//    能被中断的获取锁     获取到的锁的线程能够响应中断，当获取到锁的线程被中断时，中断异常会抛出，同时锁会释放
//
//    超时获取锁           在指定的截止时间之前获取锁，超过截止时间后仍旧无法获取则放回
//
//Lock接口的实现类
//    ReentrantLock
//        ReetrantLock和synchronized关键字一样可以用来实现线程之间的同步互斥，功能上更为强大

//            公平锁与非公平锁
//                Lock锁分为：公平锁和非公平锁。公平锁表示线程获取锁的顺序是按照线程加锁的顺序来分配的。即先来先得的FIFO先进先出顺序
//                而非公平锁就是一种获取锁的抢占机制，是随时获取锁的，和公平锁不一样的就是先来的不一定的到锁，这样可能造成某些线程一直
//                拿不到锁，结果也就是不公平的