import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by MSI on 2016/7/8.
 */
public class fanshedemo {
    public static void main(String[] args) throws Exception {
//        getcalss();
//        createobject();
//        getField();
        getMethod();
    }

    public static void getcalss() throws ClassNotFoundException {
        String classname = "Persion";
        Class clazz = Class.forName(classname);
        Class clazz1 = Class.forName(classname);
        System.out.println(clazz==clazz1);
    }

    public static void createobject() throws Exception {
        String classname = "Persion";
        Class clazz = Class.forName(classname);
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Object obj = constructor.newInstance("wxq",23);
    }

    public static void getField() throws Exception {
        String classname = "Persion";
        Class clazz = Class.forName(classname);
        Field field = null;
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);//对私有字段的访问取消检查。暴力访问
        Object object = clazz.newInstance();
        field.set(object,89);
        Object o = field.get(object);
        System.out.println(o);
    }

    public static void getMethod() throws Exception {
        Class clazz = Class.forName("Persion");
        Method method = clazz.getMethod("paramMethod",String.class,int.class);
        Object object = clazz.newInstance();
        method.invoke(object,"wxq",789);
    }
}



class Persion{
    private int age;
    private String name;
    public Persion(String name,int age){
        super();
        this.age = age;
        this.name = name;

        System.out.println("Persion param run ---" + this.name + ":" + this.age);
    }

    public Persion(){
        super();
        System.out.println("persion run");
    }

    public void show(){
        System.out.println(name + "show run---" + age);
    }

    private void privateMethod(){
        System.out.println(" method run ");
    }

    public void paramMethod(String str,int num){
        System.out.println("paramMethod run....."+str+":"+num);

    }
    public static void staticMethod(){
        System.out.println(" static method run......");
    }
}