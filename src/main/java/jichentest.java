/**
 * Created by MSI on 2016/9/8.
 */
public class jichentest {
    public static void main(String[] args){
        stu s1 = new stu("wxq");
        s1.run();
    }
}

class People{
    People(){
        System.out.println("父类空参构造函数");
    }
    People(String name){
        System.out.println("父类不是空参构造函数");
    }
}

class stu extends People{

    stu(){
        System.out.println("子类空参构造函数");
    }
    stu(String name){
//        super(name);
        System.out.println("子类不是空参构造函数");
    }
    public void run(){
        System.out.println("子类方法");
    }
}

//不写super(name)时，不管子类是用的那个构造函数，都会调用父类的空参构造函数，除非指定调用那个父类的构造函数