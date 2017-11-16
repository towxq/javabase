package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		getMethodDemo_1();
		getMethodDemo_2();
		getMethodDemo_3();
	}

	private static void getMethodDemo_3() throws Exception {
		Class clazz = Class.forName("reflect.Person");
		Method method = clazz.getMethod("paramMethod", String.class,int.class);
		Object obj = clazz.newInstance();
		method.invoke(obj, "wxq",24);
	}

	private static void getMethodDemo_2() throws Exception {
		Class clazz = Class.forName("reflect.Person");
		Method method = clazz.getMethod("show", null);//获取空参的一般方法
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("wxq",25);
	}

	private static void getMethodDemo_1() throws Exception {
		Class clazz = Class.forName("reflect.Person");
		Method[] methods = clazz.getMethods();//获取的都是公有的方法
		methods = clazz.getDeclaredMethods();//获取本类中的所有方法，包含私有
		for(Method method:methods){
			System.out.println(method);
		}

	}
}
