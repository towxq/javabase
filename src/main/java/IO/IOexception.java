package IO;

import java.io.FileWriter;
import java.io.IOException;

public class IOexception {

	private static final String LINE_SEPARATOR=System.getProperty("line.separator");

	public static void main(String[] args){
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\demo.txt");
			fw.write("abcdef"+LINE_SEPARATOR+"wxqxqxqxwqqx");
			fw.write("cdededdcdakllklakscdcasck");
		} catch (IOException e) {
			System.out.println(e.toString());
		}finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e2) {
					throw new RuntimeException("关闭失败");
				}
		}

	}
}
