package 基础知识.多线程;

import sun.awt.windows.ThemeReader;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
//        Thread1 thread1  = new Thread1("A");
//        Thread1 thread11 = new Thread1("B");
//        thread1.start();
//        thread11.start();
//
//        new Thread(new Thread2("C")).start();
//        new Thread(new Thread2("D")).start();


//        System.out.println("主线程开始!");
//        Thread1 thread12 = new Thread1("E");
//        Thread1 thread13 = new Thread1("F");
//        thread12.start();
//        thread13.start();
//        thread12.join();
//        thread13.join();
//        //在很多情况下，主线程生成并起动了子线程，如果子线程进行大量的耗时运算，主线程往往将于子线程之前结束，但如果主线程处理完其他的事务后
////        需要子线程的处理结果，也就是主线程需要等待子线程执行完之后再结束，这个时候要用到join()方法
//        System.out.println("主线程结束!");



        Object a  = new Object();
        Object b  = new Object();
        Object c  = new Object();
        MyThread myThread1 = new MyThread("1",c,a);
        MyThread myThread2 = new MyThread("2",a,b);
        MyThread myThread3 = new MyThread("3",b,c);
        new Thread(myThread1).start();
        Thread.sleep(100);
        new Thread(myThread2).start();
        Thread.sleep(100);
        new Thread(myThread3).start();
        Thread.sleep(100);
    }
}
class Thread1 extends Thread {
    private String name;
    public Thread1(String name){
        this.name = name;
    }
    public void run() {
        System.out.println(name+"线程开始!");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "---" + i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"线程结束!");
    }
}
class Thread2 implements Runnable{
    private String name;
    public Thread2(String name){
        this.name = name;
    }
    @Override
    public void run() {

        for (int i =0;i<10;i++){
            System.out.println(name+"----"+i);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class MyThread implements Runnable{

    private String name;
    private Object prev;
    private Object self;

    public MyThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while(count>0){
            synchronized(self){
                System.out.println(name);
                count--;
                self.notify();
            }
            try {
                prev.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}