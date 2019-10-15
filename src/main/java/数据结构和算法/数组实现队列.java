package 数据结构和算法;

import java.lang.reflect.Array;

public class 数组实现队列 {
        public static void main(String[] args){
            ArrayQueue arrayQueue = new ArrayQueue(10);
            arrayQueue.push(1);
            arrayQueue.push(2);
            arrayQueue.push(3);
            arrayQueue.push(4);
            arrayQueue.push(5);
            arrayQueue.push(6);
            arrayQueue.push(7);
            arrayQueue.push(8);
            arrayQueue.push(9);
            arrayQueue.push(10);
            System.out.println(arrayQueue.poll());
            System.out.println(arrayQueue.poll());
            System.out.println(arrayQueue.poll());
        }
}

class ArrayQueue{
    private Integer[] arr;//数组实现一个队列
    private int size;//表示数组中的元素
    private int start;//队列中取数的索引
    private int end;//队列中出来的索引


    ArrayQueue(int initSize){
        if(initSize<0){
            throw new IllegalArgumentException("队列大小不能为0");
        }

        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end =0;
    }

    public void push(int element){
        if (size == arr.length){
            throw new IllegalArgumentException("队列已满");
        }

        size++;
        arr[end] = element;
        end = (end == arr.length-1?0:end+1);
    }

    public Integer poll(){
        if (size==0){
            throw new IllegalArgumentException("队列已空");
        }

        size--;
        int temp = start;
        start = (start==arr.length-1?0:start+1);
        return arr[temp];
    }
}