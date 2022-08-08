package 基础知识.多线程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wxq
 * @ClassName FutureDemo
 * @Description TODO
 * @date 2021/7/12  18:15
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runAsync-->void");
        });


        System.out.println("1111");
        completableFuture.get();

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsyc--->integer");
            return 1024;
        });

        completableFuture1.whenComplete((t,u)->{
            System.out.println("t--"+t);
            System.out.println("u--"+u);
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 123;
        }).get();
    }
}

//异步
