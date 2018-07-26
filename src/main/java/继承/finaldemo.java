package 继承;

public class finaldemo {
    final int a = 1;
    final String str;
    final int c;
//    final static double d;
    //没有指定默认值，又没在初始块，构造器重指定初始值 是不合法的，在初始块中赋值的，构造器就不能赋值了，当然普通的方法不能为final修饰的成员赋值
    {
        //在初始块中为实例变量初始化，合法
        str = "wxq";
        c = 8;
    }
}
