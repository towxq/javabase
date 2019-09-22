package 设计模式;

public class 适配器设计模式 {
    public static void main(String[] args){
       phone phone = new phone();
       phone.work(new Adapter220());
}
}
interface Target{
    //220-->110
    int Convert_110V();
}

//原类
class PoerPort220{
    int Output_220(){
        int V = 220;
        System.out.println("输出220V ");
        return V;
    }
}

//适配器
class Adapter220 extends PoerPort220 implements Target{

    public int Convert_110V() {
        System.out.println("适配器开始工作");
        int input =  Output_220();
        int output = input/2;
        System.out.println("适配器变压结束");
        return output;
    }
}

class phone{
    void work(Target target){
        if(target.Convert_110V()==110){
            System.out.println("电压正常");
        }else if (target.Convert_110V()>110){
            System.out.println("变压了");
        }
    }
}