package Thread;

public class houtaithread {
	public static void main(String[] args){
		hello3 he = new hello3();
		Thread demo = new Thread(he,"线程");
		demo.setDaemon(true);
		demo.start();
	}
}

class hello3 implements Runnable{

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName()+"run");
		}
	}

}
