package redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * Created by MSI on 2016/7/8.
 */
public class redisdemo {
    public static void main(String[] args) {
        // Jedis jedis = new Jedis("localhost");
        // System.out.println("connection to server success");
        // System.out.println("Server is running "+jedis.ping());

//        Jedis jedis = new Jedis("192.168.78.128:6379");
//        System.out.println("connection to server success");
//        persion p = new persion();
//        p.setId("wxq");
//        p.setAge("255");
//        byte[] b= SerializeUtil.serialize(p);
//        jedis.set("wxq".getBytes(), b);
//        jedis.set("wxqwxq", "asdf");
//        //jedis.del("wxq");
//        persion p1 = (persion) SerializeUtil.unserialize(jedis.get("wxq".getBytes()));
//        System.out.println("redis:"+p1.getId()+":"+p1.getAge());
//        System.out.println("****"+jedis.get("wxqwxq"));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/redis.xml");
        WriteRedisService writeRedisService = (WriteRedisService) applicationContext.getBean("WriteRedisService");
        ReadRedisService readRedisService = (ReadRedisService) applicationContext.getBean("ReadRedisService");
        writeRedisService.set("aaa","wxq");
        persion p = new persion();
        p.setId("wxq");
        p.setAge("255");
        writeRedisService.set("bbb",p);
        String ss = readRedisService.get("aaa");
        persion p1 = readRedisService.get("bbb",persion.class);
        System.out.println(ss);
        System.out.println("redis:"+p1.getId()+":"+p1.getAge());

    }
}

class persion implements Serializable {
    private String id;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}

class SerializeUtil {
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }
}
