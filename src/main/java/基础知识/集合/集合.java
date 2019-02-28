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

//    HashSet  按Hash算法来存储集合中的元素，具有很好的存储和查找性能
//    1,不能保证元素的排序顺序，顺序可能与添加顺序不同，顺序也有可能发生变化
//    2,HashSet不是同步的，如果多个线程同时访问一个HashSet,必须通过代码来保证其同步
//    3,集合元素可以是空


//LinkedHashSet HashSet还有个子类LinkedHashSet,根据元素的hashCode来决定元素的存储位置，同时使用链表维护元素的次序，可以以插入顺序保存，性能略低于HashSet


//TreeSet  TreeSet是SortSet接口的实现类，TreeSet可以确保集合元素处于排序状态
// 1，自然排序 （BigDecimal,Charater,Boolean,String,Date,Time）   实现Comparable接口
// 2,定制排序

//HashSet的性能总是比TreeSet好(常用的添加，查询)，因为TreeSet需要额外的红黑树算法来维护集合元素的次序，只有当需要一个保持排序的Set时，才应该使用TreeSet
//LinkedHashSet,对于普通的插入，删除操作，LinkedHashSet比HashSet要慢一点，这是由于维护链表的开销，但是有了链表，遍历LinkedHashSet会更快
//HashSet和TreeSet都是线程不安全的

//
//ArrayList和Vector作为List的两个实现类，都是基于数组实现List的，默认的长度是10
//ArrayList是线程安全的，Vector是线程安全的，
//
//LinkedList 可以根据索引来随机访问集合中的元素，LinkedList以链表的形式保存集合中的元素，所以随机访问集合元素时性能较差，但是在插入，删除时比较出色
//总体来说 ArrayList的性能好于LinkedList
//
//Queue用于模拟队列数据结构，队列的头部保存在队列中存放时间最长的元素，队列的尾部保存在队列中存放最短的元素


//TreeMap通常比HashMap（在插入，删除），因为TreeMap底层采用红黑树来管理k-v(红黑树的每一个节点就是一个k-v)
//TreeMap的好处：TreeMap中的k-v总是处于有序状态，无须专门进行排序操作，当TreeMap来填充之后，就可以调动keyset()取得由key组成的set然后使用toArray()方法生成key数组
//接下来使用Arrays的binarySearch()方法在已排序的数组中快速查找对象
//
//对于一般的场景  使用HashMap，因为HashMap正是为快速查询设计的（HashMap底层其实也是采用的数组来存储k-v）如果程序需要一个总是排好序的Map时，则使用TreeMap
//LinkedHashMap比HashMap慢一点，因为它需要维护链表来保持Map中的k-v的添加顺序

