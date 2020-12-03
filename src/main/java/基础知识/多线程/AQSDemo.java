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
//AQS 全称AbstractQueuedSynchronizer 抽象队列同步器
//    AQS通过CLH队列 一个带有虚拟节点的双向链表，来唤醒线程是否可以竞争获取锁
//        主要有两种方式，一种是独占锁：只有一个线程能执行，一种是共享锁，可以多个线程执行
//
//      ReentrantLock的实现方式
//        内部类是个sync类，继承了AQS抽象类
//        AQS结构：head头结点，tail尾结点 state加锁次数 exclusiveOwnerThread当前占有锁的线程
//        Node结构：pre上个节点，next下个节点 waitState节点等待状态 node当前线程
//
//        lock加锁步骤：尝试加锁tryAcquire() 封装当前线程node为初始化队列，唤醒队列竞争锁，重置interrupt状态
//
//        尝试加锁TayAcquire()
//            1，首先调用tryAcquire 判断aqs中的state是否为0
//            2，如果为0 判断是否有head和tail 是否有next节点 node线程是否是当前线程，主要是判断是否有队列，以及第二节点是否是当前节点
//            3，如果没有队列或者下个node是当前线程，直接CAS尝试获取锁，获取成功true 失败false
//            4，判断是否是可重入锁，判断当前线程是否是aqs中占有锁的线程，如果是重入锁state+1 放回true
//            5，其他情况，有队列且不是重入锁，且第二个线程不是当前线程，返回false
//
//        封装线程node初始化队列
//            1，先将当前线程，封装成node
//            2，判断head是否为空
//            3，不为空说明已经存在队列，设置node pre为tail，自己设置为新tail
//            4,为空说明不存在队列，直接死循环进行以下步骤
//                a,先判断tail是否为空，为null 通过CAS设置一个空节点，赋值给head,同时tail=head
//                b,如果tail不为null,将node的pre设置为tail 同时CAS将node设置为新tail 跳出循环
//
//
//        唤醒队列竞争锁
//            1，死循环 判断当前节点pre是否是head 目的是判断自己是否是第二个节点
//            2，如果是 队列的第二个节点，就CAS尝试获取锁 走tryAcquire
//                a,获取成功，aqs就是当前node线程，设置当前node为head，旧的断开连接
//                b，获取失败走下面步骤
//            3，获取失败 或者 不是第二个节点
//                a，首先将上个节点 设置为waitState为 -1 默认是0 目的是为了解锁用
//                b,然后再次循环到这里 执行LockSupport.pack(); 等待被唤醒
//            4，如果唤醒 会调用Thread.interrupted 这个方法对lock没啥用，主要为了lockinterruptor方法 他会抛异常
//            5，唤醒后继续走，循环逻辑获取锁
//            6，出现异常走finally当前线程获取锁
//
//
//        unlock解锁步骤
//            1，unlock调用 AQS的release(1) 解锁
//            2，尝试解锁，tryRelease 返回true 解锁成功，false失败
//                a,首先state-1 得到c
//                b,当前线程不是AQS中占有锁的线程，抛异常
//                c,c=0 解锁成功，将AQS的占有锁的线程设置为null，其他返回false （重入锁state-1 可能大于0）
//            3，解锁成功 需要判断是否需要唤醒其他节点
//                a,通过是否有head判断是否存在队列，因为只有一个线程 可能不会初始化队列 没有队列需要唤醒
//                b,有队列 在判断head的waitState是否为0  不等于0 说明队列其他节点需要唤醒  等于0 head为tail 队列不需要唤醒
//                c,在判断head next 节点正常情况是next node 不为null 且waitState <=0 直接LockSupport.unpack唤醒下一个节点
//                d,极端情况next node 可能为null或者 next node >0 那么我们需要从链表尾往前遍历，找到离当前node后面最近的节点，且该node的waitState <=0





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

