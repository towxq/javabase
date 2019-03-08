package 基础知识.多线程;

public class SynchronizedDemo  implements Runnable{
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i =0;i<10;i++){
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        Thread.sleep(500);
        System.out.println("result="+count);
    }

    @Override
    public void run() {
        synchronized (SynchronizedDemo.class){
            for (int i=0;i<1000000;i++){
                count++;
            }
        }
    }
}
//synchronized关键字提供一种独占式的加锁对象，用来控制多个线程对共享资源的互斥访问，他可以保证在同一时刻只有一个线程在执行该段代码
//同时保证共享变量的内存访问性
//    互斥性：同一时刻只允许一个线程持有某个对象锁，一次实现对共享资源的互斥访问
//    可见性：确保在锁释放前，对共享变量做的修改，对随后获得锁的另一个线程是可见的
//
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

