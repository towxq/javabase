package Thread;

public class tongbuhanshuthread {
	public static void main(String[] args){
		hello7 he = new hello7();
		Thread h1 = new Thread(he);
		Thread h2 = new Thread(he);
		Thread h3 = new Thread(he);
		h1.start();
		h2.start();
		h3.start();
	}
}

class hello7 implements Runnable{
	private int count = 5;
	@Override
	public void run() {
		for(int i =0;i<10;i++){
			sale();
		}

	}

	public synchronized void sale(){//同步函数
		if(count>0){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(count--);
		}
	}

}
