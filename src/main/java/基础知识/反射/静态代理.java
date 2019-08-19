package 基础知识.反射;

public class 静态代理 {
        public static  void main(String[] args){
            lvxingshe ll = new lvxingshe(new youself());
            ll.shopping();
        }
}
interface ability{
    void shopping();
}
class youself implements ability{

    @Override
    public void shopping() {
        System.out.println("去国外旅游");
    }
}

class lvxingshe implements  ability{

    youself youself;

    lvxingshe(youself youself){
        this.youself = youself;
    }

    @Override
    public void shopping() {
        System.out.println("给你订酒店，机票");
        youself.shopping();
    }
}