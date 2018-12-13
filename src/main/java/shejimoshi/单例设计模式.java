package shejimoshi;

/**
 * Created by MSI on 2016/8/6.
 */
public class 单例设计模式 {

}

class Single{
    //线程安全
    private static final Single s = new Single();
    private Single(){}
    public static Single getInstance(){
        return s;
    }
}


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