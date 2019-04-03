package 数据结构;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MyQueueTest {
    //store elements 存储元素
    private List<Integer> data;
    // a pointer to indicate the start position 指向开始元素的指针
    private int p_start;
    public MyQueueTest(){
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    public boolean enQueue(int x){//入列
        data.add(x);
        return  true;
    }

    public boolean deQueue(){//出列
        if(isEmpty() == true){
            return false;
        }
        p_start++;
        return true;
    }

    public int Front(){
        return data.get(p_start);
    }

    public boolean isEmpty(){
        return p_start >= data.size();
    }
}

class MyCircularQueue{

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k){
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueueCir(int value){
        if (isFull()){
            return false;
        }
        if (isEmpty()){
            head =  0;
        }
        tail  =  (tail+1)%size;
        data[tail]  = value;
        return true;
    }

    public boolean deQueueCir(){
        if (isEmpty()){
            return false;
        }
        if (head==tail){
            head = -1;
            tail = -1;
            return  true;
        }
        head = (head+1)%size;
        return true;
    }

    public int Front(){
        if (isEmpty()){
            return -1;
        }
        return data[head];
    }

    public int Rear(){
        if (isEmpty()){
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty(){
        return head==-1;
    }

    public boolean isFull(){
        return ((tail+1)%size) ==head;
    }
}

public class MyQueue{
    public static void main(String[] args){
//        MyQueueTest q = new MyQueueTest();
//        q.enQueue(5);
//        q.enQueue(3);
//        if(!q.isEmpty()){
//            System.out.println(q.Front());
//        }
//        q.deQueue();
//        if(!q.isEmpty()){
//            System.out.println(q.Front());
//        }
//        q.deQueue();
//        if(!q.isEmpty()){
//            System.out.println(q.Front());
//        }

//        MyCircularQueue circularQueue = new MyCircularQueue(3);
//        circularQueue.enQueueCir(1);  // 返回true
//        circularQueue.enQueueCir(2);  // 返回true
//        circularQueue.enQueueCir(3);  // 返回true
//        circularQueue.enQueueCir(4);  // 返回false,队列已满
//        circularQueue.Rear();  // 返回3
//        if(!circularQueue.isEmpty()){
//            System.out.println(circularQueue.Rear());
//        }
//        circularQueue.isFull();  // 返回true
//        if(!circularQueue.isEmpty()){
//            System.out.println(circularQueue.isFull());
//        }
//        circularQueue.deQueueCir();  // 返回true
//        circularQueue.enQueueCir(4);  // 返回true
//        circularQueue.Rear();  // 返回4
//        if(!circularQueue.isEmpty()){
//            System.out.println(circularQueue.Rear());
//        }


        Queue<Integer> q = new LinkedList<Integer>();
        System.out.println("the first elements is:"+q.peek());
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        q.poll();
        System.out.println("the first elements is:"+q.peek());
        System.out.println("the size  is:"+q.size());
    }
}

