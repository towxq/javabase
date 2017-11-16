package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class transStreamdemo3 {
		public static void main(String[] args) throws IOException, IOException{
			readtext2();
		}
		public static void readtext2() throws IOException, FileNotFoundException{
			InputStreamReader isr = new InputStreamReader(new FileInputStream("b.txt"),"utf-8");
			char[] buf = new char[10];
			int len = isr.read(buf);
			String str = new String(buf,0,len);
			System.out.println(str);
			isr.close();
		}
}
