package 基础知识.IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("redis.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("name"));
    }
}
