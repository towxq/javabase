package 线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by MSI on 2016/9/6.
 */
public class threadtest {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+",队列中等待执行的任务的数目："+executor.getQueue().size()+",已执行玩的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable{
    private int taskNum;

    public MyTask(int num){
        this.taskNum = num;
    }

    public void run(){
        System.out.println("正在执行task" + taskNum);
        try{
            Thread.currentThread().sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("tsak" + taskNum + "执行完毕");
    }
}

//corepoolsize:核心池的大小，
//maximunPoolsize:线程池最大线程
//keepalivetime:表示线程没有执行时最多保持多久会终止，默认只有线程池中的线程大于corepoolsize,keepalivetime才会起作用
//unit：参数keepalivetime的时间单位
//workqueue:一个阻塞队列，用来存储等待执行的任务
//    ArrayBlockingQueue
//    LinkedBlockingQueue
//    SynchronousQueue
//threadFactory:线程工厂，主要来创建线程
//handler:拒绝处理任务时的策略、
//    ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
//    ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
//    ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
//    ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务

//ThreadPoolExecutor继承了AbstractExecutorService，AbstractExecutorService实现了ExecutorService，ExecutorService继承了Executor
//ThreadPoolExecutor中几个重要的方法
//1,execute(): 是Executor中声明的方法，在ThreadPoolExecutor进行了具体的实现，通过这个方法向线程池提交一个任务，交由线程池去执行
//2,submit():是ExecutorService中声明的方法，这个方法也是用来向线程池提交任务的，不过和execute()的不同的是，
//            他能返回执行的结果，只不过是用了future来获取执行结果
//3,shutdown()
//4,shutdownNow() 都用来关闭线程


//1，线程池的状态
//    定义了表示线程池状态的变量
//
//2，任务的执行
//    a,如果当前线程池中的线程数目小于corePoolsize，则每来一个任务，就会创建一个线程去执行这个任务
//    b,如果当前线程池中的线程数目>=corepoolsize，则每来一个任务，会尝试将其添加到任务缓存队列中，若添加成功，则该任务会等待空闲线程将其取出去执行
//    若添加失败，则尝试创建新的线程去执行这个任务
//    c,如果线程池中的线程数目达到maximumpoolsize,则会采取任务拒绝策略进行处理
//    d,如果当前线程池中的线程大于corepoolsize时，如果某线程空闲时间超过keepalivetime，线程将会被终结，直到线程池中的线程数目不大于corepoolsize
//    如果允许为核心池中的线程设置存活时间，那么核心池中的线程空闲时间超过keepalivetime线程也会被终止
//
//3，线程池中的线程初始化
//    默认情况下，创建线程池之后，线程池中是没有线程的，需要任务提交后才会创建线程
//    prestartcoreThread() 初始化一个核心线程
//    prestartAllCoreThreads()初始化所有核心线程
//
//4，任务缓存队列及排队策略
//    a,ArrayBlockingQueue:基于数组的先进先出队列，此队列创建时必须指定大小
//    b,LinkedBlockingQueue:基于链表的先进先出队列，如果创建时没有指定此队列大小，默认为Integer.MAX_VALUE
//    c,synchronousQueue:这个队列比较特殊，他不会保存提交的任务，而是将直接新创建一个线程来执行新来的任务
//
//5，当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：
//     a,ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
//     b,ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
//     c,ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
//     d,ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
//
//6,线程池的关闭
//     shutdown()：不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
//     shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
//
//7，线程池的容量的动态调整
//      ThreadPoolExecutor提供了动态调整线程池容量大小的方法：setCorePoolSize()和setMaximumPoolSize()，
//      setCorePoolSize：设置核心池大小
//      setMaximumPoolSize：设置线程池最大能创建的线程数目大小


//java通过Executors提供四种线程池
//    1，newCachedThreadPool  创建一个可缓存线程池，如果线程池的长度超过处理的需要，可灵活回收线程，若无可回收，则新建线程
//    2，newFixedThreadPool创建一个定长的线程池，可控制线程的最大并发数，超出的线程会在队列中等待
//    3，newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行
//    4，newSingleThreadPool创建一个单线程化的线程池，他只会用唯一的线程来执行任务，保证任务按照指定的顺序执行
