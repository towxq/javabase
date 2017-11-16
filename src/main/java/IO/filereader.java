package IO;

import java.io.FileReader;
import java.io.IOException;

public class filereader {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("D:\\demo.txt");
		
		
		
//		int  ch =0;
//		while((ch=fr.read())!=-1){
//			System.out.print((char)ch);
//		}

	
	char[] buf = new char[1024];
	int len = 0;
	while((len=fr.read(buf))!=-1){
		System.out.println(new String(buf,0,len));
	}
	}
	
}
