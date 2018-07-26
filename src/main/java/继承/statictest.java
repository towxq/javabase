package 继承;

public class statictest {
    public static void main(String[] args){
        System.out.println("persion的类变量"+persion.eyenum);
        persion persion1 = new persion();
        System.out.println("persion1"+persion1.name+"----"+persion1.eyenum);
        persion1.name = "wxq";
        persion1.eyenum = 123;
        System.out.println("persion1"+persion1.name+"----"+persion1.eyenum);
        System.out.println("persion的类变量"+persion.eyenum);
        persion persion2 = new persion();
        System.out.println("persion2"+persion2.name+"----"+persion2.eyenum);
    }
}
class persion{
    public String name;

    public static int eyenum;

}