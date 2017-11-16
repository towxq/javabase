package List;

/**
 * Created by Administrator on 2015/3/24.
 */
public class test {
    public static void main(String[] args){
        // 创建默认大小的LinkedList
        LinkedList list1 = new LinkedList();
        list1.add(new Node(12));
        list1.add(new Node(10));
        list1.add(new Node(11));
        list1.add(new Node(8));
        list1.add(new Node(9));

        System.out.println("链表默认容量为12");
        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
        System.out.println();

        list1.add(new Node(2));
        list1.add(new Node(4));
        list1.add(new Node(5));
        list1.add(new Node(7));
        list1.add(new Node(6));
        list1.add(new Node(1));
        list1.add(new Node(3));

        System.out.println("链表容量满时会自动扩容，默认为扩大12个节点容量");
        System.out.println("链表：" + list1.toString());
        System.out.println("链表第一个节点：" + list1.getFirst());
        System.out.println("链表最后一个节点节点：" + list1.getLast());
        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
        System.out.println();

        list1.remove(3);
        System.out.println("删除索引为3的节点后的情况：");
        System.out.println("链表：" + list1.toString());
        System.out.println("链表第一个节点：" + list1.getFirst());
        System.out.println("链表最后一个节点节点：" + list1.getLast());
        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
        System.out.println();

        list1.add(new Node(80));
        list1.add(new Node(90));
        System.out.println("新增两个节点的情况（新增：80,90两个数字）：");
        System.out.println("链表：" + list1.toString());
        System.out.println("链表第一个节点：" + list1.getFirst());
        System.out.println("链表最后一个节点节点：" + list1.getLast());
        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
        System.out.println();

        System.out.println("获取第8个节点的信息：" + list1.getNode(8));
        System.out.println("获取第8个节点的下一个节点信息是：" + list1.getNode(8).getNext());
        System.out.println();

        System.out.println("测试反序链表");
        System.out.println("原链表：" + list1.toString());
        System.out.println("反序链表：" + list1.reverse().toString());
        System.out.println();

        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
        System.out.println("测试在第3个索引的位置连续插入12个值为45的节点，使得链表长度超过当前容量，测试链表的自增长容量");
        System.out.println("原链表：" + list1.toString());
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        list1.insert(3, new Node(45));
        System.out.println("插入后链表：" + list1.toString());
        System.out.println("链表长度：" + list1.size());
        System.out.println("链表当前容量：" + list1.getCapacity());
    }
}
