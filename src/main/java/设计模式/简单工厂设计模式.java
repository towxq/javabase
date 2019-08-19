package 设计模式;

/**
 * Created by MSI on 2016/8/6.
 */

//客户类
public class 简单工厂设计模式 {
    public static void main(String[] args){
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);

        FactoryBMW110 factoryBMW110 = new FactoryBMW110();
        BMW110 bmw110 = factoryBMW110.createBMW1();

        FactoryBMW120 factoryBMW120 = new FactoryBMW120();
        BMW120 bmw120 = factoryBMW120.createBMW1();


    }
}

//产品类
abstract class BMW{
    public BMW(){}
}

class BMW320 extends BMW{
    public BMW320(){
        System.out.println("制造-->BMW320");
    }
}

class BMW523 extends BMW{
    public BMW523(){
        System.out.println("制造-->BMW523");
    }
}

//工厂类
class Factory{
    public BMW createBMW(int type){
        switch(type){
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}

//   简单工厂模式又称静态工厂方法模式。重命名上就可以看出这个模式一定很简单。它存在的目的很简单：定义一个用于创建对象的接口。
//        先来看看它的组成：
//        1) 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑，用来创建产品
//        2) 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。
//        3) 具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。


//产品类
abstract class BMW1{
    public BMW1(){}
}

class BMW110 extends BMW1{
    public BMW110(){
        System.out.println("制造-->BMW320");
    }
}

class BMW120 extends BMW1{
    public BMW120(){
        System.out.println("制造-->BMW523");
    }
}

//创建工厂类
interface FactoryBMW1{
    BMW1 createBMW1();
}

class FactoryBMW110 implements FactoryBMW1{

    public BMW110 createBMW1() {
        return new BMW110();
    }
}

class FactoryBMW120 implements FactoryBMW1{

    public BMW120 createBMW1() {
        return new BMW120();
    }
}