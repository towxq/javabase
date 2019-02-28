package 基础知识;

public class base {
    public static void main(String[] args){
        float af = 5.234556f;
        System.out.println(af);
        double a = 0.0;
        double c = Double.NEGATIVE_INFINITY;
        float d = Float.NEGATIVE_INFINITY;
        //看到float和double的负无穷大是相等的
        System.out.println(c==d);
        //0.0除以0.0将出现非数
        System.out.println(a/a);
        //两个非数之间是不相等的
        System.out.println(a/a==Float.NaN);
        //所有正无穷大都是相等的
        System.out.println(6.0/0 ==555.0/0);
        //负数除以0.0得到无穷大
        System.out.println(-8/a);
        double aa = 5.5;
        double bb  = 3.0;
        System.out.println(aa-bb);

        for(SeasonEnum s: SeasonEnum.values()){
            System.out.println("-----"+s);
        }
        new EnumTest().judge(SeasonEnum.SPRING);
    }
}


class demo{
    final int a;
    static {
        System.out.println("静态初始化块");
    }
    {
        a = 0;//可以给final赋值
        System.out.println("初始化块");
    }

    {
        System.out.println("初始化块2");
    }

    demo(){
        System.out.println("构造函数");
    }
}


enum SeasonEnum{
    SPRING,SUMMER,FALL,WINTER;
}

class EnumTest{
    public void judge(SeasonEnum s){
        switch(s){
            case SPRING:
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
            case FALL:
                System.out.println("fall");
                break;
            case WINTER:
                System.out.println("winter");
                break;

        }
    }
}