package 设计模式;

/**
 * Created by MSI on 2016/8/6.
 */
public class 单例设计模式 {

}
//饿汉
class Single{
    //线程安全
    private static final Single s = new Single();
    private Single(){}
    public static Single getInstance(){
        return s;
    }
}

class Single1{
    //线程安全
    private Single1(){}
    private static Single1 ss = null;
    static {
        ss = new Single1();
    }
    public static Single1 getInstance(){
        return ss;
    }
}

//懒汉模式
class Singlee {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singlee s = null;
    /* 私有构造方法，防止被实例化 */
    private Singlee() {}
    /* 静态工程方法，创建实例 */
    public static Singlee getInstace() {
        if (s == null) {
            s = new Singlee();
        }
        return s;
    }
}

class Singlee2{

//    1，memory  = allocate()分配对象的内存空间
//    2，ctorInstance()初始化对象
//    3，instance = memory 设置instance指向刚分配的内存


    //线程不安全
    private Singlee2(){}
    private static Singlee2 instance = null;
    public static Singlee2 getSinglee2(){
        if (instance==null) {//双重检测机制
            synchronized (Singlee2.class) {//同步锁
                if (instance == null) {
                    instance = new Singlee2();
                }
            }
        }
        return instance;
    }
}

class Singlee3{
    //线程不安全
    private Singlee3(){}
    //单例对象volatile+双重检测机制 -》 禁止指令重排
    private volatile static Singlee3 singlee3 = null;
    public static Singlee3 getSinglee3(){
        if (singlee3==null) {//双重检测机制
            synchronized (Singlee3.class) {//同步锁
                if (singlee3 == null) {
                    singlee3 = new Singlee3();
                }
            }
        }
        return singlee3;
    }
}

//枚举模式
class Singlee4{
    //线程安全
    private Singlee4(){}

    private static Singlee4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private Singlee4 singlee4;

        //jvm保证这个方法绝对只调用一次
        Singleton(){
            singlee4 = new Singlee4();
        }

        public Singlee4 getInstance(){
            return singlee4;
        }
    }
}