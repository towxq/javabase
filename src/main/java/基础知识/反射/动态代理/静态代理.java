package 基础知识.反射.动态代理;

public class 静态代理 {
        public static  void main(String[] args){
            中介 ll = new 中介(new 客户());
            ll.租房子();
        }
}
//代理类和被代理类在编译期间就确定下来了
interface 租房{
    void 租房子();
}
class 客户 implements 租房{

    @Override
    public void 租房子() {
        System.out.println("租房子。。。。。");
    }
}

class 中介 implements  租房{

    客户 kehu;

    中介(客户 kehu){
        this.kehu = kehu;
    }

    @Override
    public void 租房子() {
        System.out.println("给你找房。。。。");
        kehu.租房子();
        System.out.println("给你租房。。。。");
    }
}