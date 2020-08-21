package 基础知识.反射.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK动态代理 implements InvocationHandler{

    private Target target;

    public JDK动态代理(Target target) {
        this.target = target;
    }

    public static Target newProxyInstance(Target target){
        return (Target) Proxy.newProxyInstance(JDK动态代理.class.getClassLoader(),new Class<?>[]{Target.class},new JDK动态代理(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object obj =  method.invoke(target,args);
        System.out.println("invoke after");
        return obj;
    }
}
