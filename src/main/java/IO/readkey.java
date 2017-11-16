package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class readkey {
	public static void main(String[] args) throws IOException{
		//readkey();

//		
//		InputStream in = System.in;
//		InputStreamReader isr = new InputStreamReader(in);//将字节流转换为字符流
//		BufferedReader bufr = new BufferedReader(isr);
//		String line = null;
//		while((line = bufr.readLine())!=null){
//			System.out.print(line);
//		}


		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:"+File.separator+"cc.txt")));
		String line = null;
		while((line = bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
	}

	public static void readkey() throws IOException{
		InputStream in= System.in;
		int ch = 0;
		while((ch=in.read())!=-1){
			System.out.print((char)ch);
		}
	}
}
