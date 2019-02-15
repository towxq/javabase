package 基础知识.集合;

/**
 * Created by Administrator on 2015/3/20.
 */
public class SingleLinkedList{
    private Node1 head,tail;
    public SingleLinkedList(){
        head=tail =null;
    }

    public boolean isEmpty(){//判断是否为空
        if (head==null)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public void addToHead(Object item){//添加头指针 只用一次
        head = new Node1(item);
    }

    public void addToTail(Object item){//添加尾指针
        if (!isEmpty()){
            tail.next=new Node1(item);
            tail = tail.next;
        }else{
            head = tail=new Node1(item);
        }
    }

    public  void printList(){//打印
        if (isEmpty()){
            System.out.println("null");
        }else{
            for(Node1 p = head;p!=null;p=p.next){
                System.out.println(p.nodevalue);
            }
        }
    }

    public void addFirst(Object item){//表头插入节点  效率高
        Node1 newNode = new Node1(item);
        newNode.next=head;
        head=newNode;
    }

    public void addLast(Object item){//表尾插入节点  效率低
        Node1 newNode = new Node1(item);
        Node1 p = head;
        while(p.next!=null){ p=p.next;}
        p.next=newNode;
        newNode.next=null;
    }

    public void removeFirst(){//在表头删除 效率高
        if(!isEmpty())
        {
            head = head.next;
        }
        else {
            System.out.println("this is empty list");
        }
    }

    public void removeLast(){//在表尾删除  效率低
        Node1 prev = null,curr = head;
        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
            if (curr.next==null){
                prev.next = null;
            }
        }
    }

    public boolean insert(Object app,Object item){//指定的节点添加数据  app是nodevalue item是插入的节点
        Node1 prev =head,curr = head.next,newNode;
        newNode = new Node1(item);
        if (!isEmpty()){
            while((curr!=null)&&(!app.equals(curr.nodevalue))){
                prev = curr;
                curr=curr.next;
            }
            newNode.next=curr;
            prev.next=newNode;
            return true;
        }
        return false;
    }

    public void remove(Object item){//移除指定的节点
        Node1 curr = head,prev = null;
        boolean found = false;
        while (curr!=null&&!found){
            if (item.equals(curr.nodevalue)){
                if (prev==null) {removeFirst();}
                else {prev.next=curr.next;}
                found =true;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public int indexof(Object item){//返回指定元素的索引
        int index = 0;
        Node1 p;
        for(p=head;p!=null;p=p.next){
            if(item.equals(p.nodevalue)){
                return index;
            }
        }
        return -1;
    }

    public boolean contains(Object item){//是否包含指定的元素
        return indexof(item)!=-1;
    }

    public static void main(String[] args){
        SingleLinkedList t = new SingleLinkedList();
        //t.addToHead("A");
        t.addToTail("B");
        t.addToTail("C");
        t.addFirst(1);
        t.addLast(2);
        System.out.println();
        t.printList();
    }
}


class Node1{
    Object nodevalue;//数据
    Node1 next;//指向下一个节点的引用

    Node1(Object nodevalue,Node1 next){
        this.nodevalue=nodevalue;
        this.next=next;
    }

    Node1(Object nodevalue){
        this(nodevalue,null);
    }
}