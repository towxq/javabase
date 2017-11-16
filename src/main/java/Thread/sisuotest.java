package Thread;

public class sisuotest {
	public static void main(String[] args){
		sstest a = new sstest(true);
		sstest b = new sstest(false);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

class sstest implements Runnable{

	private boolean flag;
	sstest(boolean flag){
		this.flag = flag;
	}
	public void run() {
		if(flag){
			while(true){
				synchronized(MyLock.locka){
						System.out.println(Thread.currentThread().getName()+"---if locka");
					synchronized(MyLock.lockb){
						System.out.println(Thread.currentThread().getName()+"---if lockb");
					}
				}
			}
		}
		else{
			while(true){
				synchronized(MyLock.lockb){
					System.out.println(Thread.currentThread().getName()+"---if lockb");
				synchronized(MyLock.locka){
					System.out.println(Thread.currentThread().getName()+"---if locka");
				}
				}
			}
		}
		
	}
	
}