package shejimoshi;

import java.util.ArrayList;
import java.util.List;

public class 建造者设计模式 {
    public static void main(String[] args){

        //前台
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        //前台下单 做餐
        director.construct(builder);
        //好了
        Diancan computer = builder.getDiancan();
        computer.show();
    }
}


//定义点餐过程
abstract class Builder{
    public abstract void buildhanbao();
    public abstract void buildshutiao();
    public abstract void buildkele();

    //返回点的餐
    public abstract Diancan getDiancan();
}

//前台
class Director{
    public void construct(Builder builder){
        builder.buildhanbao();
        builder.buildshutiao();
        builder.buildkele();
    }
}

//做餐的
class ConcreteBuilder extends Builder{

    Diancan diancan = new Diancan();

    @Override
    public void buildhanbao() {
        diancan.ADD("汉堡");
    }

    @Override
    public void buildshutiao() {
        diancan.ADD("薯条");
    }

    @Override
    public void buildkele() {
        diancan.ADD("可乐");
    }

    @Override
    public Diancan getDiancan() {
        return diancan;
    }
}

//吃的
class Diancan{
    private List<String> parts = new ArrayList<String>();

    public void ADD(String part){
        parts.add(part);
    }

    public void show(){
        for(String s:parts){
            System.out.println(s);
        }
        System.out.println("完成");
    }
}