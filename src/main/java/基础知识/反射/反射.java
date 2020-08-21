package 基础知识.反射;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class 反射 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class的方式
        Person person = new Person();
        //1，类属性
        Class class1 = Person.class;
        //2.对象的getClass()
        Class class2 = person.getClass();
        //3.Class的静态方法 通过全类名
        Class class3 = Class.forName("基础知识.反射.Person");
        System.out.println(class1==class2);
        //字节码加载到内存中的过程称为类的加载，加载到内存中的类，我们称为运行时类，此运行时类为Class的一个实例，加载到内存中的运行时类，会缓存一段时间
        System.out.println(class2==class3);
        System.out.println(class3);


        System.out.println("--------------------------------");

        //获取运行时类以及父类的public属性
        Field[] fields = class3.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }


        System.out.println("--------------------------------");


        //获取运行时类所有属性
        Field[] fieldss = class3.getDeclaredFields();
        for (Field field:fieldss) {
            System.out.println("权限修饰符---"+Modifier.toString(field.getModifiers()));
            System.out.println("数据类型---"+field.getType());
            System.out.println("变量名---"+field.getName());
            Annotation[] annotations = field.getAnnotations();
            for (Annotation a:annotations){
                System.out.println(a);
            }
        }


        System.out.println("--------------------------------");

        //获取运行时类以及父类的public的方法
        Method[] methods = class3.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }


        System.out.println("--------------------------------");

        //获取运行时类的方法
        Method[] methodss = class3.getDeclaredMethods();
        for (Method method:methodss) {
            System.out.println(method);
        }

        System.out.println("--------------------------------");

        Method[] methodsss = class3.getDeclaredMethods();
        for (Method method:methodsss) {
            Annotation[] annotation = method.getAnnotations();
            for (Annotation a:annotation){
                System.out.println(a);
            }
        }

        System.out.println("--------------------------------");

        //通过反射创建对象
        Constructor constructor = class3.getDeclaredConstructor(String.class,String.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance("wxq","28");//创建运行时类的对象
        Person person1 = (Person) object;
        System.out.println(person1.toString());


        System.out.println("--------------------------------");
        //通过反射，调用该对象的属性，方法
        Field field = class3.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person1,"adsadas");
        System.out.println(person1.toString());

        System.out.println("--------------------------------");

        //调用方法
        Method method = class3.getDeclaredMethod("play");
        method.invoke(person1);

        //方法带参数
        Method method1 = class3.getDeclaredMethod("eat",String.class);
        method1.setAccessible(true);
        method1.invoke(person1,"asdasd");


        System.out.println("--------------------------------");
        //方法返回值
        Method method2 = class3.getDeclaredMethod("getName");
        String name = (String) method2.invoke(person1);
        System.out.println(name);

    }
}

class Person{
    private String name;
    private String age;

    @FieldInfo(value = "ad")
    public String sex;

    public Person() {
    }

    private Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private void eat(String ss){
        System.out.println("吃饭"+ss);
    }

    public void play(){
        System.out.println("玩");
    }

    @MethodInfo()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
