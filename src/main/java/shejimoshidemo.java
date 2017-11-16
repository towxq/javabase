/**
 * Created by MSI on 2016/7/9.
 */
public class shejimoshidemo {
    public static void main(String[] args){
        int i = 0;
        int sum = 0;
//        while(i<=100){
//            i=i+2;
//            sum=sum+i;
//        }
//        System.out.println(sum);
        do{
            i=i+2;
            sum=sum+i;
        }while(i<=100);
        System.out.println(sum);
    }

}
class Single{
    private static final Single s = new Single();
    private Single(){}
    public static Single getInstance(){
        return s;
    }
}

//单例设计模式
class Singlee{
    private static Singlee s = null;
    private Singlee(){}
    public  static Singlee getInstace(){
        if(s==null){
            s = new Singlee();
        }
        return s;
    }
}

