package 基础知识.多线程;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wxq
 * @ClassName CopyOnWriteArraySet
 * @Description TODO
 * @date 2021/7/10  22:19
 */
public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
//       Set<String> set = new HashSet<>();

//       Set<String> set = Collections.synchronizedSet(new HashSet<>());


       Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
