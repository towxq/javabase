package 数据结构和算法;

/**
 * @author wxq
 * @ClassName 跳台阶问题
 * @Description TODO
 * @date 2021/10/14  22:27
 */
public class 跳台阶问题 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static void main(String[] args) {
        System.out.println(jumpFloor2(4));
    }
    static int jumpFloor(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    static int jumpFloor2(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        return  jumpFloor2(number-2)+jumpFloor2(number-1);
    }


//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    int JumpFloorII(int number) {
        return 1 << --number;//2^(number-1)用位移操作进行，更快
    }
//    java中有三种移位运算符：
//            “<<” : 左移运算符，等同于乘2的n次方
//            “>>”: 右移运算符，等同于除2的n次方
//            “>>>” : 无符号右移运算符，不管移动前最高位是0还是1，右移后左侧产生的空位部分都以0来填充。与>>类似。
//            例： int a = 16; int b = a << 2;//左移2，等同于16 * 2的2次方，也就是16 * 4 int c = a >> 2;//右移2，等同于16 / 2的2次方，也就是16 / 4

}
