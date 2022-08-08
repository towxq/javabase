package 数据结构和算法;

public class 斐波那契 {
    public static void main(String[] args) {
        //0、1、1、2、3、5、8、13、21、34
        //F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
        int a = Fibonacci(4);
        System.out.println(a);
    }
//采用递归
    static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }


    //迭代法
    static int Fibonacci2(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}


