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

        String s = "wxq";
        String ss = "wxq";
        String s1 = new String("wxq");
        String ss1 = new String("wxq");
        System.out.println(s==ss);
        System.out.println(s1==ss1);

        String as = "xiaomeng2";
        final String bs = "xiaomeng";
        String ds = "xiaomeng";
        String cs = bs + 2;
        String es = ds + 2;
        System.out.println((as == cs));
        System.out.println((as == es));

        peo peo1 = new peo("abc",18);
        peo peo2 = new peo("wxq",27);
        System.out.println(peo1.getName()+"--"+peo1.getAge());
        System.out.println(peo.i);
        peo.i = 0;
        System.out.println(peo.i);
        change(peo1,peo2);
        System.out.println(peo2.getName());

        System.out.println(trycatchdemo());

        peo peo = new peo();
        System.out.println(peo.getName()+"--"+peo.getAge());
        System.out.println(1 << 2);

        int i = 1;
        double m = 1.2;
        BBb b = new BBb();
        b.a(m);
        b.a(i);

        System.out.println(8 & (15-1));
        System.out.println(8 & (16-1));
        trycatchdemo();

        System.out.println("gcd(10,6)--"+gcd(13,5));

        season season = 基础知识.season.SPRING;
        System.out.println(season);

        for (season sss:season.values()){
            System.out.println(sss);
        }

        double mss = (double) 4800/3000.0;
        int msss = (int) mss;
        System.out.println(mss);
        System.out.println(msss);

        System.out.println(1>>>16);
        System.out.println(1<<2);
        System.out.println(8>>1);

        int x=4;
        System.out.println(x++);

        FunctionalInterfaceDemo functionalInterfaceDemo = ()->{
            System.out.println("saasas");
        };
        functionalInterfaceDemo.ss();

//        List<Integer> list = new ArrayList<Integer>();
//        for (int n = 10;n<=206;n = n+2){
//            list.add(n);
//        }
//        for (int aaa:list) {
//            System.out.print(aaa+"-");
//        }
//        System.out.println();
//        System.out.println(list.size());
    }

    public static int gcd(int m,int n){
        if(m<n){
            int temp = m;
            m = n;
            n = temp;
          }
          int r = m % n;
          while(r>0){
              m = n;
              n = r;
              r = m % n;
          }
          return n;
    }

    public static void change(peo p,peo p2){
        p2.setName(p.getName());
    }

    static int trycatchdemo(){
        try{
            System.out.println(2);
            return 2;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(3);
            return 3;
        }
    }
}

@FunctionalInterface
interface FunctionalInterfaceDemo{
    void ss();
    default void aa(){
        System.out.println("aa");
    }
}


class demo{
    final int a;
    static {
        //静态代码块随着类的加载而执行，而且只执行一次，初始化类的信息
        System.out.println("静态初始化块");
    }
    {
        //每创建一个对象，就执行一次非静态代码块，可以给对象的属性等初始化
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

final class peo{
    static int i = 9;
    private String name;
    private Integer age;

    static{
        System.out.println("static chushihua  --"+i);
        i = 1;
        System.out.println("static chushihua  "+i);
    }

    {
        name = "wxq123";
        age = 123;
        System.out.println("chushihua");
    }
    peo(){}
    peo(String  name,Integer age){
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


class AAa{
    final void a(int i){
        System.out.println("a="+i);
    }
}


class BBb extends AAa{
    void a(double i){
        System.out.println("b="+i);
    }
}
//枚举的实例是常量
enum season{
    SPRING,SUMMER,AUTUMN,WINTER
}