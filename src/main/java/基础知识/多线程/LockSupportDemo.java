package 基础知识.多线程;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("--------main-------");
//
//        Thread thread = new Thread("t1"){
//            public void run(){
//                System.out.println("--------t1-------");
//                LockSupport.park();
//                System.out.println("--------t2--------");
//            }
//        };
//        thread.start();
//
//        Thread.sleep(5000);
//        System.out.println("--------m1--------------");
//        LockSupport.unpark(thread);

        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() ->{
            for (char c:a1){
                System.out.println(Thread.currentThread().getName()+"--"+c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(() ->{
            for (char c:a2){
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"--"+c);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
