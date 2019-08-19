package 基础知识.多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class AQSDemo {

}


class CountDownLatchTest{
    public static void main(String[] args){
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(){
            public void run(){
                try{
                    System.out.println("子线程"+Thread.currentThread().getName()+" is run");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+" is end");
                    countDownLatch.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try{
                    System.out.println("子线程"+Thread.currentThread().getName()+" is run");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+" is end");
                    countDownLatch.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();

        try{
            System.out.println("等待。。。。");
            countDownLatch.await();
            System.out.println("执行完毕");
            System.out.println("主线程执行。。");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


class CyclicBarrierTest{
    public static void main(String[] args){
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);
        for (int i =0;i<n;i++){
            new Writer(cyclicBarrier).start();
        }
    }
}

class Writer extends Thread{
    private CyclicBarrier cyclicBarrier;
    public Writer(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"写入完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有写入完毕");
    }
}
//AQS
//1,使用Node实现FIFO队列，可以用于构建锁或者其他同步装置的基础框架
//2，利用了一个int类型表示状态
//3，使用的方法时继承
//4，子类通过继承并通过实现它的方法管理其状态{acquire和release}的方法操纵状态
//5，可以同时实现排它锁和共享锁模式（独占和共享）

//CountDownLatch
//    CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。
//    当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
//
//    构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。这个值只能被设置一次，而且CountDownLatch没有提供任何机制去重新设置这个计数值。
//    与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。
//    这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
//    其他N 个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，他们已经完成了各自的任务。这种通知机制是通过 CountDownLatch.countDown()方法来完成的；
//    每调用一次这个方法，在构造函数中初始化的count值就减1。所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。
//Semaphore
//    Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可

//CyclicBarrier
//    通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，
//    CyclicBarrier可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
//        第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
//        第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务
//ReentrantLock(可重入锁)
//      synchronized依赖jvm
//      ReentrantLock依赖JDK  性能差不多了  当然synchronized功能实现简单

//Condition

//FutureTask



//1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
//CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
//而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
//另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
//
//2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。

