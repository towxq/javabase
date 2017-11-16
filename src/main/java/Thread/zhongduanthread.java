package Thread;

public class zhongduanthread {
	public static void main(String[] args){
		hello2 he = new hello2();
		Thread demo= new Thread(he,"线程");
		demo.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		demo.interrupt();//2s后中断线程
	}
}

class hello2 implements Runnable{

	@Override
	public void run() {
		System.out.println("执行run方法");
		try {
			Thread.sleep(10000);
			System.out.println("线程完成休眠");
		} catch (Exception e) {
			System.out.print("休眠打断");
			return;
		}
		System.out.println("线程正常终止");
	}

} 