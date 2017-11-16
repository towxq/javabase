import java.util.ArrayList;

/**
 * Created by MSI on 2016/11/16.
 */
public class listdemo {
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        people people = new people();
        people.age = "20";
        people.name = "wxq";
        people people1 = new people();
        people1.name="wxq1";
        people1.age = "24";
        arrayList.add(people);
        arrayList.add(people1);
        for(int i=0;i<arrayList.size();i++){
            people people2 = (people) arrayList.get(i);
            System.out.println(people2.age+people2.name);
        }

    }
}
class people{
    String name;
    String age;
}