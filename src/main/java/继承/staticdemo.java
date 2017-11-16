package 继承;

public class staticdemo {
	public static void main(String[] args){
		new Leaf();
		new Leaf();
	}
}

class Root{
	static{
		System.out.println("root的静态初始化");
	}
	{
		System.out.println("root的普通初始化");
	}
	public Root(){
		System.out.println("root的无参构造函数");
	}
}

class Mid extends Root{
	static {
		System.out.println("mid的静态初始化");
	}
	public Mid(){
		System.out.println("mid的普通初始化");
	}
	public Mid(String msg){
		this();
		System.out.println("mid的带参构造函数，参数是"+msg);
	}
}

class Leaf extends Mid{
	static{
		System.out.println("leaf的静态初始化");
	}
	{
		System.out.println("leaf的普通初始化");
	}
	public Leaf(){
		super("wxwqxq");
		System.out.println("执行Leaf的构造函数");
	}
}
