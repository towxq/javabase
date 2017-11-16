package reflect;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {
	public static void main(String[] args) throws Exception{
		createNewObject();
		createNewObject_2();
	}

	private static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//早期：new时候，先根据被new的类的名称找寻该类的字节码文件，并加载进内存，
//		并创建该字节码文件对象，并接着创建该字节文件的对应的Person对象.
//		reflect.Person p = new reflect.Person();

		//现在
		String name = "reflect.Person";
		//找寻改名称类文件，并加载进内存，并产生class对象
		Class clazz = Class.forName(name);
		Object obj = clazz.newInstance();
	}

	private static void createNewObject_2() throws ClassNotFoundException, Exception, Exception{
		
		/*
		 * 当获取指定名称对应类中的所体现的对象时，
		 * 而该对象初始化不使用空参数构造该怎么办呢？
		 * 既然是通过指定的构造 函数进行对象的初始化，
		 * 所以应该先获取到该构造函数。 通过字节码文件对象即可完成。
		 * 该方法是：getConstructor(paramterTypes);
		 * 
		 */

		String name = "reflect.Person";
		Class clazz = Class.forName(name);
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("wxq",23);

	}
}
