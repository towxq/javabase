package 基础知识.IO;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream fileInputStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("redis.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("redis.maxIdle"));
    }
}
