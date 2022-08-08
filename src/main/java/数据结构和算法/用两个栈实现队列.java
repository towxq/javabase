package 数据结构和算法;

import java.util.Stack;

/**
 * @author wxq
 * @ClassName 用两个栈实现队列
 * @Description TODO
 * @date 2021/10/14  22:55
 */
public class 用两个栈实现队列 {
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    public static void main(String[] args) {

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //当执行push操作时，将元素添加到stack1
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //如果两个队列都为空则抛出异常,说明用户没有push进任何元素
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        //如果stack2不为空直接对stack2执行pop操作，
        if(stack2.empty()){
            while(!stack1.empty()){
                //将stack1的元素按后进先出push进stack2里面
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
