package 基础知识.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class unsafedemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cc = Class.forName("sun.misc.Unsafe");
        Constructor[] constructor = cc.getConstructors();
        Method[] method = cc.getDeclaredMethods();
        for (Method method1:method){
            System.out.println(method1.getName());
        }
    }
}
