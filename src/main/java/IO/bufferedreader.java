package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bufferedreader {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("demo.txt");
		BufferedReader bufr = new BufferedReader(fr);
		String line = null;
		while((line=bufr.readLine())!=null){
			//System.out.println(line);
		}
		
		FileReader fr1 = new FileReader("demo1.txt");
		char[] buf  = new char[1024];
		int len = 0;
		while((len=fr1.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
	}
	
}
