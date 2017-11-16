package 继承;

public class dmeo {
	public static void main(String[] args){
//		int a =1;
//		if(a==1){
//			System.out.println("1");
//		}else if(a==1){
//			System.out.println("2");
//		} if(a==1){
//			System.out.println("3");
//		}
		
//		String s = "wxq";
//		String s1 = "wx"+"q";
//		String s2 = "w";
//		String s3 = "xq";
//		String s4 = s2+s3;
//		if(s==s4){
//			System.out.println("���");
//		}else
//		{
//			System.out.println("�����");
//		}
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		System.out.print(s==s1);
	}
}


class Singleton{
	private static Singleton instance;
	private Singleton(){}
	public static Singleton getInstance() {
		if(instance==null){
			instance = new Singleton();
		}
		return instance;
	}
	
}