package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class transStreamdemo {
	public static void main(String[] args) throws IOException{
		InputStream in = System.in;
		//将字节流转成字符的桥梁，装换流
		InputStreamReader isr = new InputStreamReader(in);
		//字符流
		BufferedReader bufr = new BufferedReader(isr);
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(osw);
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}
}
