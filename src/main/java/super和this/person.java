package super和this;

public class person {
    person(){
        System.out.println("person run");
    }
    person(String name){
        System.out.println("person run name"+name);
    }
    person(String name,String age){
        System.out.println("person run name"+name+"age="+age);
    }
    String name;
    public void run(){
        name = "aaa";
    }
}
