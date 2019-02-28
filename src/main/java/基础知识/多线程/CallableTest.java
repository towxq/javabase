package 基础知识.多线程;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();

//        Future<Integer> future = executor.submit(task);
//        executor.shutdown();

        Thread.sleep(1000);
        System.out.println("主线程执行任务");
        System.out.println("task运行结果"+futureTask.get());
        System.out.println("所有任务执行结束");

    }
}


class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程进行计算中。。。");
        Thread.sleep(3000);
        int sum = 0;
        for (int i=0;i<100;i++){
            sum = sum +i;
        }
        return sum;
    }
}

//Callable接口代表一段可以调用并返回结果的代码
//Future接口表示异步任务，是还没有完成的任务出来的未来结果，所以Callable用于产生结果，Future用于获得结果
//Callable接口使用泛型去定义他的返回类型，Exectors类提供了一些有用的方法在线程池中执行Callable内的任务，由于Callable任务是并行的
//我们必须等他的返回结果Future为我们解决这个问题，在线程池提交Callable任务后返回了一个Future对象，使用它可以知道Callable任务的状态
//和得到Callable返回的执行结果，Future提供了get方法让我们可以等待Callable结束并获取它的执行结果

//Future提供了三种功能
//    1，判断任务是否完成
//    2，能够中断任务
//    3，能够获取任务执行的结果

//get方法：获取计算结果（如果还没计算完，也是必须等待的）
//cancel方法：还没计算完，可以取消计算过程
//isDone方法：判断是否计算完
//isCancelled方法：判断计算是否被取消
