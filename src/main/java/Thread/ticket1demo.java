package Thread;

public class ticket1demo {
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
		ticket2 t1 = new ticket2();
		Thread d1 = new Thread(t1);
		Thread d2 = new Thread(t1);
		//Thread d3 = new Thread(t1);
		d1.start();
		d2.start();
	}
}

class ticket2 implements Runnable{
	private int num = 100;
	Object obj = new Object();
	public void run() {
		while(true){
		synchronized(obj){
			if(num<=0) break;
			if(num>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"----sale----"+num--);
			}
		}
		}
	}
	
}