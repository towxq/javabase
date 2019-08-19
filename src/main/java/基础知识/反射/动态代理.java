package 基础知识.反射;

import java.awt.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理 {
    public static  void main(String[] args){
        messi messi = new messi();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        ADAbility adAbility = (ADAbility)myInvocationHandler.blind(messi);
        adAbility.ad();
    }
}

interface ADAbility{
    void ad();
}

class messi implements ADAbility{

    @Override
    public void ad() {
        System.out.println("我是梅西，我天生要强");
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object obj;//实现了接口的被代理对象

    //给被代理的对象实例化
    //返回一个代理类对象
    public Object blind(Object obj) {
       this.obj = obj;
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    //通过代理类的对象发起对被重写的方法的调用时，都会转为如下的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("我是经纪人，我可以");

       Object returnval = method.invoke(obj,args);
       return  returnval;
    }
}