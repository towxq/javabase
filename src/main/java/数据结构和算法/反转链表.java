package 数据结构和算法;

/**
 * @author wxq
 * @ClassName 反转链表
 * @Description TODO
 * @date 2021/10/14  22:36
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        printList(a);
        ListNode f = ReverseList(a);
        printList(f);
    }

    private static void printList(ListNode a) {
            System.out.print(a.val);
            if (a.next!=null){
                printList(a.next);
            }else {
                System.out.println();
            }

    }

    public static ListNode ReverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            //保存要反转到头来的那个节点
            next = head.next;
            //要反转的那个节点指向已经反转的上一个节点
            head.next = pre;
            //上一个已经反转到头部的节点
            pre = head;
            //一直向链表尾走
            head = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        //1. 递归头  终止递归条件
        if(head == null || head.next == null) return head;
        //2. 递归体  自顶向下深入
        ListNode tail = reverseList(head.next);
        //3. 回溯    自底向上跳出
        head.next.next = head;
        head.next = null;
        return tail;
    }

}