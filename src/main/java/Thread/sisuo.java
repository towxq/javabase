package Thread;

public class sisuo {
	public static void main(String[] args){
		ticket t = new ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			
		}
		t.flag = false;
		t2.start();
	}
}

class ticket implements Runnable{
	
	private int num = 100;
	Object obj = new Object();
	boolean flag = true;
	public void run(){
		if(flag){
			while(true){
				synchronized (obj) {
					show();
				}
			}
		}
		else{
			while(true)
				this.show();
		}
	}
	private void show() {
		synchronized (obj) {
			if(num>0)
			{
				try {
					Thread.sleep(10);
				} catch (Exception e) {}
				System.out.println(Thread.currentThread().getName()+"----sale---"+num--);
			}
		}
		
	}
}