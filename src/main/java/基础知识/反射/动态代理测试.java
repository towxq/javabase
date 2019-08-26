package 基础知识.反射;

public class 动态代理测试 {
    public static void main(String[] args){
        //创建测试对象
        Target target = new TargetImpl();
        Target jdk = JDK动态代理.newProxyInstance(target);
        Target cglib = CGLIb动态代理.newProxyInstance(TargetImpl.class);
        jdk.test(1);
        cglib.test(2);

    }
}
