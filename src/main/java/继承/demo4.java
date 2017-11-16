package 继承;

public class demo4 {
	public static void main(String[] args) throws Exception{
		//add(5,"wxq");
		for(int i =0 ;i<10;i++){
			System.out.println("------");
			if(i==5){
				throw new Exception("出错了");
			}
		}
	}


	public static void add(String a,int b){
		System.out.println("a="+a+" b="+b);
	}
	public static void add(int m,String n){
		System.out.println("m="+m+" n="+n);
	}
}
