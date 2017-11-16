package Thread;

public class Resourcedemo {
	public static void main(String [] args){
		Resource r = new Resource();
		Input in  = new Input(r);
		Output out = new Output(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
		
	}
}

class Resource{
	private String name;
	private String sex;
	private boolean flag = false;
	
	public synchronized void set(String name,String sex){
		if(flag){
			try {
				this.wait();
			} catch (Exception e) {
				
			}
			this.name = name;
			this.sex = sex;
			flag = true;
			this.notify();
		}
	}
	
	public synchronized void out(){
		if(!flag){
			try {
				this.wait();
			} catch (Exception e) {
				
			}
			System.out.println(name+"---"+sex);
			flag = false;
			notify();
		}
	}
}

class Input implements Runnable{

	Resource r;

	Input(Resource r){
		this.r = r;
	}
	public void run() {
		int x = 0;
		while(true){
			if(x==0){
				r.set("saax", "woman");
			}
			else{
				r.set("dick", "man");
			}
		}
		
	}
	
}

class Output implements Runnable{
	Resource r;
	Output(Resource r){
		this.r = r;
	}
	public void run() {
		while(true){
			r.out();
		}
		
	}
	
}



























