package 基础知识.反射;

import javafx.beans.binding.ObjectExpression;
import org.springframework.cglib.proxy.MethodInterceptor;

import javax.security.auth.login.Configuration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理AOP {
    public static void main(String[] args){
        A a = new A();
        Object object = MyProxy.getProxyInstance(a);
        AA aa = (AA) object;
        aa.info();
    }
}
interface AA{
    void info();
}
class A implements AA{

    @Override
    public void info() {
        System.out.println("我是插入代码");
    }
}

class Codeone{
    public void method1(){
        System.out.println("======方法1====");
    }

    public void method2(){
        System.out.println("=====方法2=====");
    }
}

class MyInvocationHandler2 implements InvocationHandler{

    Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Codeone codeone = new Codeone();
        codeone.method1();

        Object returnv2 = method.invoke(object,args);
        codeone.method2();

        return returnv2;
    }
}

class MyProxy{
    public static Object getProxyInstance(Object object){
        MyInvocationHandler2 handler = new MyInvocationHandler2();
        handler.setObject(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object
                .getClass().getInterfaces(), handler);
    }
}