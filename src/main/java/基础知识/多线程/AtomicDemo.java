package 基础知识.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger count = new AtomicInteger(200);
    public static void main(String[] args){
        System.out.println(count.getAndIncrement());
        System.out.println(count.get());
    }
}

