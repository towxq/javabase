package 继承;

public class demo5 extends Animal{
	public demo5(){
		super("灰太狼",3);
		System.out.println("demo5无参的构造函数");
	}
	public static void main(String[] args){
		new demo5();
	}
}
class Creature{
	public Creature(){
		System.out.println("Creature无参的构造函数");
	}
}

class Animal extends Creature{
	public Animal(String name){
		System.out.println("Animal带一个参数的构造函数"+"改动物name为"+name);
	}
	public Animal(String name,int age){
		this(name);
		System.out.println("Animal带二个参数的构造函数"+"改动物name为"+name+"age为"+age);
	}
}