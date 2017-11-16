package Thread;

public class sleepthread {
	public static void main(String[] args){
		hello1 he = new hello1();
		Thread demo = new Thread(he,"线程");
		demo.start();
	}
}


class hello1 implements Runnable{
	@Override
	public void run() {
		for(int i =0;i<3;i++){
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}