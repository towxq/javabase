package 基础知识.多线程;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedDemo{
    public static void main(String[] args) {
        Number number = new Number();
        System.out.println(ClassLayout.parseInstance(number).toPrintable());
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.start();
        t2.start();

    }
}

class Number implements Runnable{

    private int num = 0;

    private Object object = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (object){

                object.notify();

                if (num<100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---"+num);
                    num++;
                    try {
                         object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
//volatile和synchronized的区别
//    1，使用上的区别
//        a,volatile关键字只能用于修饰实例变量或者类变量，不能修饰方法以及方法参数和局部变量，常量等
//        b,synchronized关键字不能用于对变量的修饰，只能用于修饰方法或者语句块
//        c, volatile修饰的变量可以为null  synchronized关键字同步语句块的monitor的对象不能为null
//    2,对原子性的保证
//        a,volatile无法保证原子性
//        b,由于synchronized是一种排他的机制，因此被synchronized关键字修饰的同步代码是无法被中途打断的，因此能够保证代码的原子性
//    3,对可见性的保证
//        a,两者均可以保证共享资源在多线程的可见性，但实现机制不同
//        b,synchronized借助于jvm指令monitor enter和monitor exit对通过排他的方式使得同步代码串行化，在monitor exit时所有共享资源将会被刷新到主内存中
//        c,相比与synchronized关键字，volatile使用机器指令（偏硬件） “lock” 的方式迫使其他线程工作内存中的数据失败，不得到主内存中进行再次加载
//    4,对有序性的保证
//        a,volatile关键字禁止JVM编译器以及处理器对其进行重排序，所以它能够保证有序性
//        b,虽然synchronized关键字所修饰的同步方法也可以保证顺序性，但是这种顺序是以程序的串行化执行换来的
//    5，其他
//        a,volatile不会使线程陷入阻塞
//        b,synchronized关键字会使线程进入阻塞


//    1,synchronized关键字提供一种锁的机制，能够保证共享变量的互斥访问，从而防止数据不一致的问题
//    2,synchronized关键字包括moniter enter和monitor exit 两个JVM命令，能够保证在任何时候任何线程执行到monitor enter成功之前都必须从主内存
//        中获取数据，而不是从缓存中，在monitor exit运行成功后，共享变量被更新后的值必须刷入主内存
//    3,synchronized的指令严格遵守java happens-before规则，一个monitor exit之前必要有一个monitor enter
//
//    synchronized提供一种互斥机制，也就是在同一时刻，只能有一个线程访问同步资源，

//synchronized的获取和释放锁由jvm实现，用户不需要显示的获取和释放锁，非常方便，但是当线程尝试获取锁的时候，获取不到就会一直阻塞
//同步代码块
//    锁的是指定对象实例
//    public void test1(){
//        synchronized(this){
//
//        }
//    }

//    锁的是指定的类对象
//    public void test2(){
//        synchronized(Test.class){
//
//        }
//        }
//
//同步方法
//    作用方法时，锁是当前的对象实例
//    public synchronized void test3(){
//
//    }
//    静态方法锁是类对象
//    public synchronized static void test4(){
//
//    }

//对象锁monitor机制
//    添加synchronized关键字之后，执行同步代码后首先执行monitorenter指令，退出的时候monitorexit指令。使用synchronized执行同步，其关键字
//    就是必须要对对象的监视器monitor进行获取，当前线程获取monitor后才能继续往下执行，否则就只能等待，而这个获取的过程是互斥的，即同一时刻
//    只有一个线程能够获取到monitor。在同一个线程中，线程不需要再次获取同一把锁，synchronized先天具有重入性，每个对象拥有一个计数器，当前
//    线程获取该对象锁后，计数器就会加一，释放锁后就会将计数器减一
//
//    任意一个对象都拥有自己的监视器，当这个对象有同步块或者这个对象的同步方法调用时，执行方法的线程必须先获取该对象的监视器才能进入同步
//    块和同步方法，如果没有获取到监视器的线程将会被阻塞在同步和同步方法的入口处，进入到BLOCKED状态
//
//            Monitor.Enter                           Monitor.Enter成功                     Monitor.Exit
//        ------------------->监视器（Monitor）--------------------------->对象（Object）------------------>
//                        /                    |
//                     /                       |Monitor.Enter失败
//                  / Monitor.Exit             |
//               /   后通知，出队列            |
//              ---同步队列（Synchronized）-----

//        任意线程对Object的访问，首先要获得Object的监视器，如果没有获取到监视器的线程将会被阻塞在同步和同步方法的入口处果获取失败，该线程就进入同步状态，线程状态变为BLOCKED，当Object的监视器占有
//        者释放后，在同步队列中得线程就会有机会重新获取该监视器


//汇编层面 lock comxchg

