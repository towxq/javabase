package 数据结构和算法;

public class 数组实现栈 {
        public static void main(String[] args){
            ArrayStack arrayStack = new ArrayStack(5);
            arrayStack.push(1);
            arrayStack.push(2);
            arrayStack.push(3);
            arrayStack.push(4);
            arrayStack.push(5);
            System.out.println(arrayStack.pop());
            System.out.println(arrayStack.pop());
         }
}


class ArrayStack{
    private Integer[] arr;//表示栈容器
    private int index;//栈的当前的元素下标

    ArrayStack(Integer initSzie){
        if (initSzie<0){
            throw new IllegalArgumentException("栈容器要大于0");
        }
        arr = new Integer[initSzie];
        index = 0;
    }

    public void push(Integer element){
        if (index == arr.length){
            throw new ArrayIndexOutOfBoundsException("栈已满");
        }

        arr[index++] = element;
    }

    public Integer pop() {
        if (index==0){
            throw new ArrayIndexOutOfBoundsException("栈已空");
        }

        return arr[--index];
    }
}