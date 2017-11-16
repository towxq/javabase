package Thread;

public class createThread {
	public static void main(String[] args){
		demothread d1 = new demothread("aa");
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d1);
		t1.start();
		t2.start();
	}
}


class demothread implements Runnable{
	private String name;
	private int i = 100;
	Object obj = new Object();

	demothread(String name){
		this.name = name;
	}
	public void run(){
		while(true){
			if(i<=0)
				break;
			synchronized (obj) {
				if(i>0)
					System.out.println(name+"----"+i+"---"+Thread.currentThread().getName());
				i--;
			}
		}
	}
}
