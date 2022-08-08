package 设计模式;

/**
 * @author wxq
 * @ClassName 原型设计模式
 * @Description TODO
 * @date 2021/9/18  11:19
 */
public class 原型设计模式 {
    //使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象
    public static void main(String[] args) {
        Prototype prototype = new ConcreteProtoType("wxq");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}

abstract class Prototype{
    abstract Prototype myClone();
}

class ConcreteProtoType extends Prototype{

    private String filed;

    public ConcreteProtoType(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcreteProtoType(filed);
    }

    @Override
    public String toString(){
        return filed;
    }
}
