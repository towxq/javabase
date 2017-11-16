package IO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class propertiesIO {
	public static void main(String[] args){
		try {
			InputStream in = new FileInputStream("D:\\test.properties");
			Properties pro = new Properties();
			pro.load(in);
			String value = (String)pro.get("value");
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
