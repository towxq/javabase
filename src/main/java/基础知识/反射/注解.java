package 基础知识.反射;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 注解 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = zhujiedemo.class;
        Constructor<?>[] constructors = cls.getConstructors();
        ClassInfo classInfo = cls.getAnnotation(ClassInfo.class);
        System.out.println("注解值：" + classInfo.value());
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
            if (fieldInfo != null) {
                System.out.print("注解值：" + fieldInfo.value());
            }
        }
        System.out.println();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            if (methodInfo != null) {
                System.out.print("注解值：" + method.getModifiers()+methodInfo.name()+"--"+methodInfo.age());
            }
            System.out.println();

        }
    }
}

@ClassInfo("wxq")
class zhujiedemo {

    @FieldInfo("qwe")
    String name;
    @FieldInfo("21")
    int age;

    @MethodInfo(name = "asdas", age = "45")
    void getdata() {
        System.out.println("name=" + name + "--age=" + age);
    }
}