package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bytestreamdemo {
	public static void main(String[] args) throws IOException{
		demo_read();
		demo_write();
	}
	public static void demo_read() throws IOException{
		FileInputStream fis = new FileInputStream("demo.txt");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
	}
	public static void demo_write() throws IOException{
		FileOutputStream fos = new FileOutputStream("demo-3.txt");
		fos.write("wxqwxqwxqwxqwxqccccccccccc".getBytes());
		fos.close();
	}
}
