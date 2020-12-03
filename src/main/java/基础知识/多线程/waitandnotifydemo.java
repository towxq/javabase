package 基础知识.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class waitandnotifydemo {
    public static void main(String[] args){
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();
//        Object obj = new Object();
//        Thread t1 = new Thread(() ->{
//            synchronized (obj){
//                for (char c:a1){
//                    try {
//                        System.out.println(Thread.currentThread().getName()+"--"+c);
//                        obj.notify();
//                        obj.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                obj.notify();
//            }
//        },"t1");
//
//        Thread t2 = new Thread(() ->{
//            synchronized (obj) {
//                for (char c : a2) {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + "--" + c);
//                        obj.notify();
//                        obj.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                obj.notify();
//            }
//        },"t2");
//        t1.start();
//        t2.start();


        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
;        new Thread(()->{
            try {
                lock.lock();
                for (char c : a1) {
                    System.out.println(Thread.currentThread().getName() + "--" + c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : a2) {
                    System.out.println(Thread.currentThread().getName() + "--" + c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
