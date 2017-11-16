/**
 * Created by MSI on 2016/7/8.
 */
public class threaddemo {
    public static void main(String[] args) {
//        demo1 demo1 = new demo1();
//        Thread t1= new Thread(demo1);
//        Thread t2 = new Thread(demo1);
//        t1.start();
//        t2.start();

//        demo d1 = new demo(demo1);
//        demo d2 = new demo(demo1);
//        d1.start();
//        d2.start();

//        Ticket t1 = new Ticket();
//        Thread d1 = new Thread(t1);
//        Thread d2 = new Thread(t1);
//        d1.start();
//        d2.start();

//        demo2 demo2 = new demo2();
//        demo1 demo1 = new demo1();
//        Thread t1 = new Thread(demo1);
//        t1.start();
////        demo2.start();
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        demo3 demo3 = new demo3();
        Thread thread = new Thread(demo3);
        thread.start();
    }
}
class demo extends Thread {
    public void run(){
        for(int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + "------" + i);
        }
    }
}
class demo1 implements Runnable{
    public void run(){
        for(int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + "******" + i);
        }
    }
}

class Ticket implements Runnable{
    private int num = 100;
    Object object = new Object();
    public void run(){
        while(true){
            synchronized(object){
                if (num>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"******sale****"+num--);
                }
            }
        }
    }
}

class demo2 extends Thread{
    int i = 10;
    public void  run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class demo3  implements Runnable{
    int i = 100;
    Object object = new Object();
    public void run(){
        while(true) {
            if(i>0) {
                synchronized (object) {
                    System.out.println("**********" + i--);
                }
            }
        }
    }
}