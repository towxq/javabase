package 基础知识.泛型;

public class demo {

    public static void main(String[] args) {
        System.out.println(add(121,345));

        Poin<String> p = new Poin<String>();
        p.setVar("wxq");
        System.out.println(p.getVar());

        Notepad<String,Integer> notepad =  new Notepad<String,Integer>();
        notepad.setKey("ww");
        notepad.setValue(30);
        System.out.println(notepad.getKey()+":"+notepad.getValue());

        Info<String> info = new InfoImpl<String>("wxqwxq");
        System.out.println(info.getVar());
    }


    private static <T extends Number> int add(T a,T b){
        return a.intValue()+b.intValue();
    }
}

class Poin<T>{//泛型类
    private T var;
    public T getVar(){
        return var;
    }

    public void setVar(T var){
        this.var = var;
    }
}

class Notepad<K,V>{//多元泛型
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

interface Info<T>{//泛型接口
    public T getVar();
}

class InfoImpl<T> implements Info<T>{//泛型接口的实现类
    private T var;

    public InfoImpl(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}

class Info1<T extends Number>{    // 此处泛型只能是数字类型
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}


//<?> 无限制通配符
//<? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
//<? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类