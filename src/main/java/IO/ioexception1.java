package IO;

import java.io.FileWriter;
import java.io.IOException;

public class ioexception1 {
	private static final String line = System.getProperty("line.separator");
	public static void main(String[] args){
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\demo1.txt");
			fw.write("十一放假了啊 啊 啊 啊"+line+"好爽啊");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw!= null){
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
	}
}
