package 基础知识.集合;

/**
 * Created by Administrator on 2015/3/24.
 */
public class LinkedList {
    /** 默认容量大小及链表容量满的时候每次自动增加的大小 */
    private static final int DEFAULT_CAPACITY_SIZE=12;
    //链表中的节点的集合
    private Node[] nodes;
    //指针，指向链表末端待添加的位置，默认指向0的位置
    private int endPos = 0;
    //当前链表容量
    private int capacity = 0;

    public LinkedList(){
        nodes = new Node[DEFAULT_CAPACITY_SIZE];//构造函数 默认大小的节点集合
        capacity = DEFAULT_CAPACITY_SIZE;//当前链表容量12
    }

    public LinkedList(int capacity){
        nodes = new Node[capacity];//构造函数 当前容量的节点集合
        this.capacity = capacity;//传的值是容量
    }

    public int size(){
        return endPos;//链表大小
    }

    public int capacity(){
        return this.nodes.length;//反回nodes数组的长度
    }
    public void add(Node node){//向链表中加入节点
        if (this.endPos>=this.capacity-1){
            capacity = this.endPos+1+DEFAULT_CAPACITY_SIZE;
            Node[] nodesTemp = new Node[capacity];
            System.arraycopy(nodes,0,nodesTemp,0,this.endPos);
            nodes = nodesTemp;//超出默认长度的添加
        }
        if(endPos==0){
            node.setIndex(0);
            nodes[endPos] = node;//如果是0添加0元素
        }else if(endPos>0&&endPos<=this.capacity()-1){
            node.setIndex(endPos);
            nodes[endPos]=node;
            nodes[endPos-1].setNext(nodes[endPos]);
        }
    }

    public void remove(int index){//删除链表中的节点位置  index 要删除的节点位置
        if(index>this.capacity()-1||index>=this.endPos||index<0){
            throw new RuntimeException("没有位置索引"+index+"存在");
        }
        if(index==endPos-1){
            nodes[index] = null;
            return;
        }
        for(;0<=index&&index<endPos-1;index++){
            if(index==0){
                nodes[index]=nodes[index+1];
                nodes[index].setIndex(index);
            }else{
                nodes[index]=nodes[index+1];
                nodes[index].setIndex(index);
                nodes[index-1].setNext(nodes[index]);
            }
        }
        endPos--;
    }

    public void update(int index,Object value){//更新指定链表位置节点的值
        if(index>this.capacity()-1||index>=this.endPos||index<0){
            throw new RuntimeException("没有位置索引"+index+"存在");
        }
        nodes[index].setValue(value);
    }

    public Node getNode(int index){//获取指定链表节点的值
        if(index>this.capacity()-1||index>=this.endPos||index<0){
            throw new RuntimeException("没有位置索引"+index+"存在");
        }
        return nodes[index];
    }

    public void insert(int index,Node node){//在链表指定位置插入节点
        if(index>this.capacity()-1||index>=this.endPos||index<0){
            throw new RuntimeException("没有位置索引"+index+"存在");
        }
        if(this.endPos>=this.capacity()-1){
            capacity = this.endPos+1+DEFAULT_CAPACITY_SIZE;
            Node[] nodesTemp = new Node[capacity];
            System.arraycopy(nodes,0,nodesTemp,0,this.endPos);
            nodes=nodesTemp;
        }
        Node[] nodesTemp = new Node[size()-index];
        System.arraycopy(nodes,index,nodesTemp,0,nodesTemp.length);
        for(int i =0,len=nodesTemp.length;i<len;i++){
            nodesTemp[i].setIndex(nodesTemp[i].getIndex()+1);
        }
        endPos++;
        node.setIndex(index);
        System.arraycopy(nodesTemp,0,nodes,index+1,nodesTemp.length);
        node.setNext(nodes[0]);
        nodes[index]=node;
        nodes[index-1].setNext(nodes[index]);
        nodes[index].setNext(nodes[index+1]);
    }

    public Node getFirst(){//获取链表第一个节点
        return nodes[0];
    }
    public Node getLast(){//获取最后一个节点
        return nodes[endPos-1];
    }

    public LinkedList reverse(){//链表反转
        Node[] nodesTemp = new Node[capacity];
        for(int i=0,j=endPos-1;i<endPos&&j>=0;i++,j--){
            nodesTemp[i]=nodes[j];
            nodesTemp[i].setIndex(i);
            if(j>0){
                nodesTemp[i].setNext(nodes[j-1]);
            }
        }
        nodes=nodesTemp;
        return this;
    }

    public String toString(){
        StringBuilder strBui = new StringBuilder();
        for(int i =0;i<endPos;i++){
            strBui.append(nodes[i].toString());
            if(i<endPos){
                strBui.append(",");
            }
        }
        return strBui.toString();
    }

    public int getCapacity(){
        return capacity;
    }
}
