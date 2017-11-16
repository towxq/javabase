package zhengze;

public class demo {
	public static void main(String[] args){
		String qq = "12392323";
		String regex = "[1-9][0-9]{4,14}";
		boolean b = qq.matches(regex);
		System.out.println(qq+":"+b);
	}
	public static void function(){
		String str = "sadaaaaaaaads";
		
	}
}
