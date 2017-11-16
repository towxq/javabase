package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copymp3test {
	public static void main(String[] args) throws IOException{
		//copy_1();
		copy_2();
	}
	//没效率  别用
	public static void copy_1() throws IOException{
		FileInputStream fis = new FileInputStream("11.apk");
		FileOutputStream fos = new FileOutputStream("11-copy.apk");
		int ch =0;
		while((ch=fis.read())!=-1){
			fos.write(ch);
		}
		fos.close();
		fis.close();
	}
	
	public  static void copy_2() throws IOException{
		FileInputStream fis = new FileInputStream("11.apk");
		FileOutputStream fos = new FileOutputStream("22-copy.apk");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
	}
}
