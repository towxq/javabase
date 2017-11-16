package List;

/**
 * Created by Administrator on 2015/3/20.
 */
public class LinkDemo {

        private Node_Single head = null;//头结点
        private Node_Single tail = null; //尾节点

        public void initList(Node_Single node){//初始化一个链表（设置head）
        head = node;
        head.next=tail;
    }
    public void addTolist(Node_Single node){//添加一个元素
        if(head==null){
            initList(node);
        }else{
            Node_Single tmp = head;
            head = node;
            node.next = tmp;
        }
    }

    public void delete(Node_Single node,LinkDemo myList){//遍历链表，删除某一节点
        if(myList==null){
            return;
        }
        Node_Single tmp = null;
        for(tmp = myList.getHead();tmp!=null;tmp=tmp.next){
            if (tmp.next!=null&&node.getKey().equals(tmp.next.getKey())){ //该元素和后一个元素相同。指针指向下一元素的下一元素
                if (tmp.next.next!=null){
                    tmp.next=tmp.next.next;
                }else{
                    tmp.next=null;
                }
            }
        }

    }

    public void printlist(LinkDemo myList){
        Node_Single tmp = null;
        for(tmp = myList.getHead();tmp!=null;tmp=tmp.next){
            System.out.println(tmp.getKey());
        }
    }

    public void setHead(Node_Single head) {
        this.head = head;
    }

    public void setTail(Node_Single tail) {
        this.tail = tail;
    }

    public Node_Single getHead() {
        return head;
    }

    public Node_Single getTail() {
        return tail;
    }

    public  static void main(String[] args){
        LinkDemo myList = new LinkDemo();
        Node_Single node_1 = new Node_Single("1");
        Node_Single node_2 = new Node_Single("2");
        Node_Single node_3 = new Node_Single("3");
        Node_Single node_4 = new Node_Single("4");
        Node_Single node_5 = new Node_Single("5");
        Node_Single node_6 = new Node_Single("6");
        Node_Single node_7 = new Node_Single("7");
        myList.addTolist(node_1);
        myList.addTolist(node_2);
        myList.addTolist(node_3);
        myList.addTolist(node_4);
        myList.addTolist(node_5);
        myList.addTolist(node_6);
        myList.addTolist(node_7);
        myList.delete(node_7,myList);
        myList.printlist(myList);
    }
}


class Node_Single{
    public String key;  //节点值
    public Node_Single next;  //指向下一个的指针
    public Node_Single(String key){//初始化 head
        this.key=key;
        this.next=null;
    }
    public Node_Single(String key,Node_Single next){
        this.key= key;
        this.next=next;
    }
    public String getKey(){
        return key;
    }

    public void setKey(){
        this.key=key;
    }
    public Node_Single getNext(){
        return next;
    }
    public void setNext(Node_Single next){
        this.next=next;
    }
    public String toString(){
        return "Node_Single[key="+key+",next="+next+"]";
    }

}
