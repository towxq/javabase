package spring.aop.aopdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EnjoyInvocationHandler implements InvocationHandler {
    Object object;
    public EnjoyInvocationHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("enjoy before");
        return method.invoke(object,args);
    }
}
