package Thread;

//静态的同步函数使用的锁是  该函数所属字节码文件对象 
//可以用 getClass方法获取，也可以用当前  类名.class 表示。

public class staticsynfunctionlockdemo {
	public static void main(String[] args){
		Ticket1 t = new Ticket1();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {

		}
		t.flag = false;
		t2.start();
	}
}

class Ticket1 implements Runnable{
	private static int num = 100;
	boolean flag = true;
	@Override
	public void run() {
		if(flag){
			while(true){
				if(num<=0)
					break;
				System.out.println("---");
				synchronized(Ticket1.class){
					if(num>0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e){

						}
						System.out.println(Thread.currentThread().getName()+".....obj...."+num--);
					}
				}
			}
		}
		else{
			while(true)
				this.show();
		}
	}
	private static synchronized void  show() {
		if(num>0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

			}
			System.out.println(Thread.currentThread().getName()+".....function...."+num--);

		}

	}

}