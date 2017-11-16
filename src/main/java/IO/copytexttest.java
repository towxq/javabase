package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copytexttest {
	public static void main(String[] args) throws IOException{
		//1,读取一个已有文本文件，使用字符流和文件相关联
		FileReader fr = new FileReader("D:\\demo.txt");
		//2,创建一个目的，用于存储读到的数据
		FileWriter fw = new FileWriter("D:\\demo1.txt");
		//3,频繁的读写
		int ch =0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
}
