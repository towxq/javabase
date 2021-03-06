package 基础知识.反射.动态代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIb动态代理 implements MethodInterceptor{

    private CGLIb动态代理() {
    }

    public static <T extends Target> Target newProxyInstance(Class<T> targetInstanceClazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CGLIb动态代理());
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept before");
        Object obj =  methodProxy.invokeSuper(o,objects);
        System.out.println("intercept after");
        return  obj;
    }
}
