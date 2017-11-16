package super和this;

import java.util.UUID;

public class student extends person {
	student(){
		super("wxq","24");//调用父类的构造函数
		System.out.println("student run");
	}
	public void run(){
		String name = "bbbb";//super调用父类的同名变量
		super.run();//不调用此方法时，super.name返回的是父类的成员变量的值null
		System.out.println(name);
		System.out.println(super.name);
	}

	public static void main(String[] args){
		student s = new student();
		s.run();
	}
}
