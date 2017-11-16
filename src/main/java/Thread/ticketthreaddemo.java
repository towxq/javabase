package Thread;

public class ticketthreaddemo {
	public static void main(String[] args){
		hello6 he = new hello6();
		Thread h1 = new Thread(he);
		Thread h2 = new Thread(he);
		Thread h3 = new Thread(he);
		h1.start();
		h2.start();
		h3.start();
	}
}

class hello6 implements Runnable{
	private int count = 5;
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			synchronized(this){
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
		
	}
	
}