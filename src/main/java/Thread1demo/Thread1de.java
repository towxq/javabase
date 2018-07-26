package Thread1demo;

public class Thread1de {
	public static void main(String[] args){
		thread1 t1 = new thread1();
		thread1 t2 = new thread1();
		thread2 t3 = new thread2();
		Thread d1 = new Thread(t3);
		Thread d2 = new Thread(t3);

		thread3 thread3 = new thread3();
		Thread thread = new Thread(thread3);
		thread.start();
		//t1.start();
		//t2.start();
//		d1.start();
//		d2.start();
	}
}

class thread1 extends Thread{
	public void run(){
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"--1--"+i);
		}
	}
}

class thread2 implements Runnable{
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"--2--"+i);
		}
	}
}

class thread3 extends Thread{
	public void run(){
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"--3--"+i);
		}
	}
}