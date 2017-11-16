package Thread;

public class youxianjithread {
	public static void main(String[] args){
		Thread h1 = new Thread(new hello4(),"A");
		Thread h2 = new Thread(new hello4(),"B");
		Thread h3 = new Thread(new hello4(),"C");
		h1.setPriority(8);
		h2.setPriority(2);
		h3.setPriority(6);//ȡ����˭��ȥ��cpu��Դ
		h1.start();
		h2.start();
		h3.start();
	}
}

class hello4 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
