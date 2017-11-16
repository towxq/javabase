package shejimoshi;

/**
 * Created by MSI on 2016/9/8.
 */
public class 代理设计模式 {
    public static void main(String[] args){
        people people = new people();
        people.setCash(60000);
        people.setUsername("abc");

        people people2 = new people();
        people2.setCash(1000);
        people2.setUsername("zxc");

        people people1 = new people();
        people1.setUsername("wxq");
        people1.setVip("vip");
        people1.setCash(100000000);

        proxyclass proxyclass = new proxyclass();
        proxyclass.setPeople(people);
        proxyclass.buy_mycar();

        proxyclass.setPeople(people1);
        proxyclass.buy_mycar();

        proxyclass.setPeople(people2);
        proxyclass.buy_mycar();
    }
}

//买车接口
interface buy_car{
    public void buy_mycar();
}

//具有买车行为的people类
class people implements buy_car{
    private int cash;
    private String vip;
    private String username;

    public void buy_mycar(){
        System.out.println(username+" vip 直接买车");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }
}

//代理类
class proxyclass implements buy_car{
    private people people;

    public people getPeople() {
        return people;
    }

    public void setPeople(people people) {
        this.people = people;
    }

    public void buy_mycar(){
        if (people.getVip()=="vip"){
            people.buy_mycar();
            return;
        }
        if (people.getCash()>=50000){
            System.out.println(people.getUsername() +" 买车了");
        }else{
            System.out.println(people.getUsername() +" 没钱不能买车");
        }
    }
}