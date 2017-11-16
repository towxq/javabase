package Thread;

public class SynFunctionLockdemo {
		public static void main(String[] args){
			Ticket2 t = new Ticket2();
			Thread t1 = new Thread();
			Thread t2 = new Thread();
			t1.start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
			}
			t.flag=false;
			t2.start();
		}
}

class Ticket2 implements Runnable{
	private int num=100;
	boolean flag = true;
	public void run() {
		if(flag){
			while(true){
				//System.out.println("---");
				synchronized(this){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
					System.out.println(Thread.currentThread().getName()+"---obj---"+num--);
				}
			}
		}
		else{
			while(true){
				this.show();
			}
		}
		
	}
	private synchronized void show() {
		if(num>0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
			}
			System.out.println(Thread.currentThread().getName()+"---function--"+num--);
		}
	}
	
}