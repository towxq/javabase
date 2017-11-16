package Thread;

public class deadlockdemo1 {
	public static void main(String[] args){
		tdemo t1 = new tdemo();
		Thread d1 = new Thread(t1);
		Thread d2 = new Thread(t1);
		d1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.flag = false;
		d2.start();
	}
}

class tdemo implements Runnable{
	private int num = 100;
	Object obj = new Object();
	boolean flag = true;
	public void run(){
		if(flag){
			while(true)
			{
				synchronized(obj){
					show();
				}
	}
	}
		else{
			while(true)
			this.show();
		}
	}
	private synchronized void show() {
		synchronized(obj){
			if(num>0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"----sale---"+num--);
			}
		}
		
	}
	}

