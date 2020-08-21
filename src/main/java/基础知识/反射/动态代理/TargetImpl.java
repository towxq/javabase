package 基础知识.反射.动态代理;

public class TargetImpl implements Target{


    @Override
    public int test(int i) {
        System.out.println("--"+i);
        return i;
    }
}
