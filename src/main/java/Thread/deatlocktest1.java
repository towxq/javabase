package Thread;

public class deatlocktest1 {
	public static void main(String[] args){
		locakdemo a = new locakdemo(true);
		locakdemo b = new locakdemo(false);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

class locakdemo implements Runnable{
	private boolean flag;
	locakdemo(boolean flag){
		this.flag=flag;
		}
	public void run() {
		if(flag){
			while(true){
				synchronized(mylockdemo.locka){
					System.out.println(Thread.currentThread().getName()+"...if   locka...");
					synchronized(mylockdemo.lockb){
						System.out.println(Thread.currentThread().getName()+"...if   lockb...");
					}
				}
			}
		}else{
			while(true){
				synchronized(mylockdemo.lockb){
					System.out.println(Thread.currentThread().getName()+"...else   lockb...");
					synchronized(mylockdemo.locka){
						System.out.println(Thread.currentThread().getName()+"...else   locka...");
					}
				}
			}
		}
	}
	
}

class mylockdemo{
	public static final Object locka = new Object();
	public static final Object lockb = new Object();
}

