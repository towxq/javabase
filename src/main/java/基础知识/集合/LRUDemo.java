package 基础知识.集合;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wxq
 * @ClassName LRUDemo
 * @Description TODO
 * @date 2021/8/27  19:30
 */
public class LRUDemo {
    public static void main(String[] args) {
        LRU lru = new LRU(5,0.75f);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(7,7);
        System.out.println(lru);
        System.out.println(lru.get(4));
        lru.put(6,666);
        System.out.println(lru);
    }
}
class LRU<K,V> extends LinkedHashMap<K,V>{
    //保存缓存的容量
    private int capacity;


    public LRU(int capacity,float loadFactor){
//        super(capacity,loadFactor,true);
        this.capacity= capacity;
    }


    //重写removeEldestEntry()方法设置何时移除旧元素
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当元素个数大于了缓存的容量, 就移除元素
        return size()>this.capacity;
    }
}
