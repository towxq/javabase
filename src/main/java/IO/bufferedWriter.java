package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bufferedWriter {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("buf.txt");
		//为了提高写入的效率，使用字符流缓冲区
		//创建了一个字符流的缓冲对象，并指定要被缓冲的流对象相关联
		BufferedWriter bufw = new BufferedWriter(fw);
		bufw.write("xxxxxxx"+LINE_SEPARATOR+"abcd");
		bufw.write("acjkcdock");
		bufw.newLine();
		bufw.write("aaaaaaaaa");
		bufw.flush();//使用缓冲区刷新方法将数据刷到目地中
		}
	
	}

