package 基础知识.多线程;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wxq
 * @ClassName CopyOnWriteArrayList
 * @Description TODO
 * @date 2021/7/10  22:19
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        list.forEach(System.out::println);

        List<String> list1 = new ArrayList<String>();
//        List<String> list2 = new Vector<>();

//        List<String> list2 = Collections.synchronizedList(new ArrayList<>());

        List<String> list2 = new CopyOnWriteArrayList<>();




        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list2);
            },String.valueOf(i)).start();
        }
    }
}
//java.util.ConcurrentModificationException 并发修改异常