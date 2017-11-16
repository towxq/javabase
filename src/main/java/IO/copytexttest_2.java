package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copytexttest_2 {
	private static final int BUFFER_SIZE = 1024;
	public static void main(String[] args){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("demo1.txt");
			fw = new FileWriter("demo2.txt");
			//创建一个临时容器。用于缓存读到的字符
			char[] buf = new char[BUFFER_SIZE];
			//定义一个变量记录读到的字符数
			int len = 0;
			while((len=fr.read(buf))!=-1){

				fw.write(buf,0,len);
			}
		} catch (Exception e) {
			System.out.println("读写失败");
			throw new RuntimeException("读写失败");
		} finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
