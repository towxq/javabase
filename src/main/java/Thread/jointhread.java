package Thread;

public class jointhread {//现成的加入
	public static void main(String[] args){
		hello he = new hello();
		Thread demo = new Thread(he,"线程");
		demo.start();
		for(int i = 0;i<50;i++){
			if(i>0){
				try {
					demo.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("main 线程执行-->"+i);
		}
	}
}

class hello implements Runnable{

	@Override
	public void run() {
		for(int i =0;i<3;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}

}
