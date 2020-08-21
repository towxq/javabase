package 基础知识.多线程;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("主线程开始!");
//        MThread mThread = new MThread();
//        Thread thread1 = new Thread(mThread);
//        Thread thread2 = new Thread(mThread);
//        thread1.start();
//        thread2.start();

//        Thread3 thread3 = new Thread3();
//        Thread3 thread4 = new Thread3();
//        thread3.start();
//        thread4.start();
//        thread3.join();
//        thread4.join();
        //在很多情况下，主线程生成并起动了子线程，如果子线程进行大量的耗时运算，主线程往往将于子线程之前结束，但如果主线程处理完其他的事务后
        //需要子线程的处理结果，也就是主线程需要等待子线程执行完之后再结束，这个时候要用到join()方法
//        System.out.println("主线程结束!");

//        maipiao maipiao = new maipiao();
//        Thread thread = new Thread(maipiao);
//        Thread thread1 = new Thread(maipiao);
//        Thread thread2 = new Thread(maipiao);
//        thread.start();
//        thread1.start();
//        thread2.start();


        //死锁
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(){
            @Override
            public void run() {
                synchronized(lock1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("no 1 我拿的锁1");
                    synchronized(lock2){
                        System.out.println("no 1 我拿的锁2");
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("no 2 我拿的锁2");
                    synchronized(lock1){
                        System.out.println("n0 2 我拿的锁1");
                    }
                }
            }
        }).start();
    }
}

class Thread3 extends Thread{
    public void run(){
            for (int i =0;i<100;i++){
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+"-----"+i);
                }

        }
        }
}

class MThread implements Runnable{

    @Override
    public void run() {
        for (int i =0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }
        }
    }
}

class maipiao implements Runnable {
    private int num = 100;

    public void run(){
        while (true){
            synchronized(maipiao.class) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "-----" + "余票=" + num);
                    num--;
                } else {
                    break;
                }
            }
        }
    }
}