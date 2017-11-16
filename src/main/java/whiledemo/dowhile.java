package whiledemo;

public class dowhile {
	public static void main(String[] args){
		int x = 1;
		do{
			System.out.println("x="+x);
			x++;
		}
		while(x<1);


		int y =2;
		switch(x)//byte,short,int char
		{
			case 1:
				System.out.println("a");
				break;
			case 2:
				System.out.println("b");
				break;
			default:
				System.out.println("c");
				break;
		}

	}
}
//do while语句的特点：无论条件是否满足，循环体至少执行一次
//if和switch的应用：
//
//if:
//	1,对具体的值进行判断。
//	2,对区间判断。
//	3,对运算结果是boolean类型的表达式进行判断。
//
//switch:
//	1,对具体的值进行判断。
//	2,值的个数通常是固定的。
//	对于几个固定的值判断，建议使用switch语句，因为switch语句会将具体的答案都加载进内存。
//	效率相对高一点。


//continue:继续。
//作用的范围：循环结构。
//continue：结束本次循环，继续下次循环。
//如果continue单独存在时，下面不要有任何语句，因为执行不到。