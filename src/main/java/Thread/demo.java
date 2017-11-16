package Thread;
/*
进程：正在进行中的程序(直译).
		
线程：就是进程中一个负责程序执行的控制单元(执行路径)
一个进程中可以多执行路径，称之为多线程。

一个进程中至少要有一个线程。

开启多个线程是为了同时运行多部分代码。

每一个线程都有自己运行的内容。这个内容可以称为线程要执行的任务。

多线程好处：解决了多部分同时运行的问题。

多线程的弊端：线程太多回到效率的降低。


其实应用程序的执行都是cpu在做着快速的切换完成的。这个切换是随机的。


JVM启动时就启动了多个线程，至少有两个线程可以分析的出来。

1，执行main函数的线程，
		该线程的任务代码都定义在main函数中。

2，负责垃圾回收的线程。


*/
public class demo {
//	创建线程方式一：继承Thread类。
//
//	步骤：
//	1，定义一个类继承Thread类。
//	2，覆盖Thread类中的run方法。
//	3，直接创建Thread的子类对象创建线程。
//	4，调用start方法开启线程并调用线程的任务run方法执行。

    public static void main(String[] args){


//		demo2 d1 = new demo2("wxq");
//		demo2 d2 = new demo2("abc");
//		d1.start();
//		d2.start();

        demo3 d3 = new demo3("aa");
        demo3 d4 = new demo3("bb");
        Thread t1 = new Thread(d3);
        Thread t2 = new Thread(d4);
        t1.start();
        t2.start();

    }
}

class demo2 extends Thread{
    private String name;
    demo2(String name){
        super(name);
    }
    public void run(){
        for(int x=0;x<100;x++){
            System.out.println(name+"-----x"+x+"-----name"+Thread.currentThread().getName());
        }
    }
}
//创建线程的第二种方式：实现Runnable接口。
//
//1,定义类实现Runnable接口。
//2，覆盖接口中的run方法，将线程的任务代码封装到run方法中。
//3，通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递。
//	为什么？因为线程的任务都封装在Runnable接口子类对象的run方法中。
//	所以要在线程对象创建时就必须明确要运行的任务。
//
//4，调用线程对象的start方法开启线程。
//
//
//实现Runnable接口的好处：
//1，将线程的任务从线程的子类中分离出来，进行了单独的封装。
//	按照面向对象的思想将任务的封装成对象。
//2，避免了java单继承的局限性。
//
//所以，创建线程的第二种方式较为常用。
class demo3 implements Runnable{
    private String name;
    demo3(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for(int x=0;x<100;x++){
            System.out.println(name+"-----x"+x+"-----name"+Thread.currentThread().getName());
        }
    }

}
