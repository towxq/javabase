package Thread;

public class yieldthread {
	public static void main(String[] args){
		Thread h1 = new Thread(new hello5(),"A");
		Thread h2 = new Thread(new hello5(),"B");
		h1.start();
		h2.start();
	}
}

class hello5 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName());
			if(i==3){
				System.out.println("线程的礼让");
				Thread.currentThread().yield();
			}
		}
	}

}
