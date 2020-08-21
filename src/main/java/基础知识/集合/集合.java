package 基础知识.集合;

import java.util.*;

public class 集合 {

    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("java");
        books.add("python");
        books.add("android");


        HashSet hashSet = new HashSet();
        hashSet.add("1111");
        hashSet.add("1111");
        hashSet.add("2222");
        hashSet.add("3333");
        hashSet.add("4444");

        for (Object ss:hashSet) {
            System.out.println(ss.toString());
        }

        Iterator iterator = books.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list.add("aaa");
        list1.add(123);
        System.out.println(list.getClass()==list1.getClass());

        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("ss","sad");
        hashMap.put("sadsad","adasd");
        hashMap.put("ss","sdsdas");
        System.out.println(hashMap.get("ss"));
    }

}



class Z implements Comparable{//定制排序
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

//集合主要有两个接口派生出来


//                                                      Collection接口
//                                                          |
//                                                          |
//            Set接口  无序集合，元素不可重复             Queue接口  队列                 List接口  有序集合，元素可以重复
//                                                                                         |
//                                                                                         |
//       EnumSet抽象类   SortedSet接口   HashSet类        Deque接口  PriorityQueue类        |   ArrayList类     Vector类
//                    |           |                           |   \                        |
//                    |           |                           |     \                      |
//                    |           |                           |       \                    |
//           TreeSet类      LinkedHashSet类             ArrayDeque类    LinkedList类---------                    Stack类




//                                                                                      Map接口
//
//                              HashMap类  线程不安全，key,value允许为空                Hashtable类  线程安全key,value不能为空            SortedMap接口
//
//                              LinkedHashMap类                                        Properties类                                     TreeMap类
//




//Set
    //TreeSet
        // TreeSet是SortSet接口的实现类，TreeSet可以确保集合元素处于排序状态
        // TreeSet的底层使用NavigableMap存储元素，是有序的，非线程安全。还有一个TreeMap的public构造函数
            // 1，自然排序 （BigDecimal,Charater,Boolean,String,Date,Time）   实现Comparable接口
            // 2,定制排序 Comparator compare

    //LinkedHashSet
            //  HashSet还有个子类LinkedHashSet,根据元素的hashCode来决定元素的存储位置，同时使用链表维护元素的次序，可以以插入顺序保存，性能略低于HashSet
            //  底层采用LinkedHashMap存储元素，按照插入顺序排序

    // HashSet
        // HashSet的底层采用HashMap实现，确保元素不重复。key是存储的元素，value是Object，无序且非线程安全。
        // 按Hash算法来存储集合中的元素，具有很好的存储和查找性能
        // 1,不能保证元素的排序顺序，顺序可能与添加顺序不同，顺序也有可能发生变化
        // 2,HashSet不是同步的，如果多个线程同时访问一个HashSet,必须通过代码来保证其同步
        // 3,集合元素可以是空

            //TreeSet和LinkedHashSet都是有序的，他们有什么区别
            //        LinkedHashSet没有实现SortedSet接口，有序依赖LinkedHashMap的有序性，按照插入顺序确保有序
            //        TreeSet实现了SortedSet接口，有序性依赖NavigableMap，NavigableMap又继承自SortedMap，这个接口的有序性依赖按照key的自然排序

            // 什么是fail-fast
            //      当使用迭代器迭代时，如果发现集合有更改，则快速失败响应，抛出异常
            //      通过一个属性modCount每次对集合的修改会加一，与遍历前记录的值比较，不一致就抛出异常

            // HashSet的性能总是比TreeSet好(常用的添加，查询)，因为TreeSet需要额外的红黑树算法来维护集合元素的次序，只有当需要一个保持排序的Set时，才应该使用TreeSet
            // LinkedHashSet,对于普通的插入，删除操作，LinkedHashSet比HashSet要慢一点，这是由于维护链表的开销，但是有了链表，遍历LinkedHashSet会更快
            // HashSet和TreeSet都是线程不安全的



//List
//        ArrayList
//            底层是数组，初始长度为10，扩容为原来的1.5倍,支持随机访问，通过索引访问元素，速度快。
//
//        Vector
//            线程安全的，底层是数组，初始为10，扩容为原来的2倍

//        LinkedList
//             是一个双向链表实现的List，添加元素，可以添加到尾部，或者头部。

//Map
//       HashMap
//            HashMap实现采用了数组+链表+红黑树的结构，数组元素又称为桶,默认的初始容量为16，装载因子为0.75，扩容为原来的2倍，当元素大于8时转为红黑树
//            单列表节点包含hash,key,value,next ,添加元素时key如果为空则放入第一个数组所在的链表中，key的hash值是key的hashCode和长度-1进行位位运算，
//            table的长度为2的n次方，当长度不够，会扩容进行resize()操作，插入链表的采用头插法，多线程下会出现线程安全问题，出现死循环。



//      Treemap
//           使用红黑树存储元素，保证元素按照Key的大小遍历


//      HashTable
//            底层是散列表（数组和链表的结合体），默认长度为11，扩容因子0.75 hash是对数组的长度取模，扩容为原来的2倍+1，所有方法synchronized修饰，线程安全


//      LinkHashMap
//            LinkedHashMap内部是一个双向链表，保证元素的插入的顺序访问，可以看成是LinkedList+HashMap,继承HashMap，增加了顺序访问的特性
//            LinkedHashMap维护了一个双向链表存储所有元素，存储节点，继承HashMap的Node类，before和after用于双向链表存储所有的元素
//            构造方法accessOrder等于false说明双向链表是按插入顺序存储元素，true实现了访问顺序存储元素，实现了LRU缓存的淘汰策略


//      ConcurrentHashMap
//            是HashMap的线程安全版本，采用分段锁的设计，每个分段锁维护几个桶，多个线程可以同时访问不同分段锁上的桶，提高并发，使用的ReentrantLock,默认是16个Segment


//      CopyOnWriteArrayList
//            ArrayList的线程安全版本，内部是数组实现，每次对数组的修改会完全拷贝一份新的数组来修改，在替换老的数组，只堵塞写，不堵塞读，实现读写分离，写时加锁ReentrantLock
//            保证最终一致性，不保证实时一致性



        //TreeMap通常比HashMap（在插入，删除），因为TreeMap底层采用红黑树来管理k-v(红黑树的每一个节点就是一个k-v)
        //TreeMap的好处：TreeMap中的k-v总是处于有序状态，无须专门进行排序操作，当TreeMap来填充之后，就可以调动keyset()取得由key组成的set然后使用toArray()方法生成key数组
        //接下来使用Arrays的binarySearch()方法在已排序的数组中快速查找对象


        //对于一般的场景  使用HashMap，因为HashMap正是为快速查询设计的（HashMap底层其实也是采用的数组来存储k-v）如果程序需要一个总是排好序的Map时，则使用TreeMap
        //LinkedHashMap比HashMap慢一点，因为它需要维护链表来保持Map中的k-v的添加顺序
