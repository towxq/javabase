package 基础知识.多线程;

import sun.awt.windows.ThemeReader;

public class VolatileDemo {
        volatile int inc = 0;

        void increase(){
            inc++;
        }

        public static void main(String[] args){
            final VolatileDemo v = new VolatileDemo();
            for (int i=0;i<10;i++){
                new Thread(){
                    public void run(){
                        for (int n=0;n<1000;n++){
                            v.increase();
                        }
                    }
                }.start();
            }

            while(Thread.activeCount()>1){
                Thread.yield();
                System.out.println(v.inc);
            }
        }
}
//一旦一个变量被volatile修饰后
//1，保证了不同线程对这个变量的操作时的可见性，就是一个线程修改了某个变量得值，对其他线程是立即可见的
//2，禁止进行指令重排序

//volatile关键字禁止指令重排序有两层意思
//1，当程序执行到volatile变量得读操作或者写操作时，在其前面的操作的更改肯定全部进行，且结果已经对后面的操作可见，在其后面的操作肯定还没进行
//2，进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行
//
//
//使用volatile必须具备两个条件
//1，对变量的写操作不依赖于当前值
//2，该变量没有包含在具有其他变量的不等式中
//    1，标记变量  2，double check
