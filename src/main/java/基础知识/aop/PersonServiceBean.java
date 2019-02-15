package 基础知识.aop;

/**
 * Created by MSI on 2016/7/17.
 */
public class PersonServiceBean implements PersonService {

    public String getPersonName(Integer id) {
        System.out.println("我是getPersonName()方法");
        return "xxx";
    }

    public void save(String name) {
        throw new RuntimeException("我爱例外");
        //System.out.println("我是save()方法");
    }

    public void update(String name, Integer id) {
        System.out.println("我是update()方法");
    }

}

