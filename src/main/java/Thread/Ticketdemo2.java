package Thread;

public class Ticketdemo2 {
	public static void  main(String[] args){
		ticket1 t = new ticket1();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class ticket1 implements Runnable{
	private int num = 100;
	Object obj = new Object();
	@Override
	public void run() {
		while(true){
			if(num<=0)
				break;
			System.out.println("--");
			synchronized(obj){
				if(num>0){
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
					}
					System.out.println(Thread.currentThread().getName()+"------"+num--);
				}
			}
		}

	}

}

//线程安全问题产生的原因：
//
//1，多个线程在操作共享的数据。
//2，操作共享数据的线程代码有多条。
//
//当一个线程在执行操作共享数据的多条代码过程中，其他线程参与了运算。
//就会导致线程安全问题的产生。 
//
//
//解决思路；
//就是将多条操作共享数据的线程代码封装起来，当有线程在执行这些代码的时候，
//其他线程时不可以参与运算的。
//必须要当前线程把这些代码都执行完毕后，其他线程才可以参与运算。 
//
//在java中，用同步代码块就可以解决这个问题。
//
//同步代码块的格式：
//synchronized(对象)
//{
//	需要被同步的代码 ；
//}
//
//同步的好处：解决了线程的安全问题。
//
//
//同步的弊端：相对降低了效率，因为同步外的线程的都会判断同步锁。
//
//
//同步的前提：同步中必须有多个线程并使用同一个锁。
