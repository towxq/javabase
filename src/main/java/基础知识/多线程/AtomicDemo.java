package 基础知识.多线程;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDemo {
    static AtomicInteger count = new AtomicInteger(200);
    static AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    static AtomicLong atomicLong = new AtomicLong(100L);
    public static void main(String[] args){
        System.out.println(count.getAndIncrement());
        System.out.println(count.get());
    }
}

//什么是CAS
//使用锁时，线程获取锁是一种悲观锁策略，即假设每一次执行临界区代码都会产生冲突，所以当前线程获取到锁的时候同时也会阻塞其他线程获取该锁
//而CAS（又称无锁操作）是一种乐观锁策略，他假设所有的线程访问共享资源的时候不会出现冲突，既然不会冲突自然不会阻塞其他线程的操作，因此
//线程就不会出现阻塞停顿的状态，那么，如果出现冲突了怎么办？无锁操作是使用CAS（compare and swap）又叫做比较交换鉴别线程是否出现冲突
//出现冲突就重试当前操作直到没有冲突为止
//
//CAS比较交换的过程可以通俗的理解为CAS（V.O.N）包含三个值为别为
//V 内存地址存放的实际值
//O 预期的值
//N 更新的值
//
//当V O 相同时也就是旧值和内存中实际的值相同表明该值没有被其他线程更改过，即该旧值O就是目前来说最新的值了，自然而然可以将新值N赋值给V
//反之 V和O不相同，表明该值已经被其他线程改过了该旧值O不是最新版本的值，所以不能将新值N赋给V 返回V即可，当多个线程使用CAS操作一个变量
//只有一个线程会成功，并成功更新，其余会失败，失败的线程会重新尝试，当然也可以选择挂起线程，CAS的实现需要硬件指令集的支撑


//synchronized VS CAS
//synchronized最主要的问题是：在存在线程竞争的情况下会出现线程阻塞和唤醒锁带来的性能问题，因为这是一种互斥同步（阻塞同步），而CAS并不是武断的
//挂起线程，当CAS操作失败后进行一定的尝试，而非进行耗时的挂起唤醒的操作，因此也叫做飞阻塞同步
//
//CAS的问题
//1， ABA问题
//    因为CAS会检查旧值有没有变化，这里存在这样一个有意思的问题。比如一个旧值A变为了成B，然后再变成A，
//    刚好在做CAS时检查发现旧值并没有变化依然为A，但是实际上的确发生了变化。解决方案可以沿袭数据库中常用的乐观锁方式，添加一个版本号可以解决。原来的变化路径A->B->A就变成了1A->2B->3C。
//
//2，自旋时间过长
//    使用CAS的非阻塞同步，也就是说不会将线程挂起，会自旋进行下一次尝试，如果这里自旋时间过长对性能是很大的消耗，如果JVM能支持处理器提供的pause指令，那么在效率上会有一定的提升


//Unsafe类在sun.misc包下，Unsafer类提供了一些底层操作，atomic包下的原子操作类的也主要是通过Unsafe类提供的compareAndSwapInt，compareAndSwapLong等一系列提供CAS操作的方法来进行实现
//汇编 lock cmpxchg指令