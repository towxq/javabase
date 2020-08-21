package 基础知识.反射.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理 {
    public static  void main(String[] args){
        mingxing mingxing = new mingxing();
        ad adAbility = (ad) ProxyFactory.getProxyInstance(mingxing);
        adAbility.ad();

        System.out.println("------------------------");

        客户 kehu = new 客户();
        租房 zf = (租房) ProxyFactory.getProxyInstance(kehu);
        zf.租房子();

    }
}
//动态代理如何加载到内存中的代理类，动态的创建一个代理类及其对象
//通过代理类的对象调用方法时，如何动态的去调用被代理类中同名的方法
interface ad{
    void ad();
}

class mingxing implements ad{

    @Override
    public void ad() {
        System.out.println("弄点广告");
    }
}

class fangfa{
    public void fangfa1(){
       System.out.println("fangfa1---------------");
    }
    public void fangfa2(){
       System.out.println("fangfa2---------------");
    }
}

class ProxyFactory{
    public static Object getProxyInstance(Object obj){//obj被代理的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        //                      被代理类的加载器                                  接口
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要被代理的对象

    public void bind(Object obj){
        this.obj = obj;
    }

    //通过代理类的对象，调用方法时，会自动的调用invock方法
    //将被代理类要执行的方法声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj 被代理的对象
        fangfa fangfa = new fangfa();
        fangfa.fangfa1();
        Object returnValue =  method.invoke(obj,args);
        fangfa.fangfa2();
        return returnValue;
    }
}