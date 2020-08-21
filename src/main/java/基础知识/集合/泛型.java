package 基础知识.集合;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class 泛型 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");

        //list1.add(20);出错
        Class c1 = list.getClass();
        Class c2 = list1.getClass();

        System.out.println(c1 == c2);

        try {
            Method m = c2.getMethod("add", Object.class);
            m.invoke(list1, 1000);
        }
        catch(Exception e) {

            e.printStackTrace();
        }

        System.out.println(list1.size());
        System.out.println(list1);

    }
}
