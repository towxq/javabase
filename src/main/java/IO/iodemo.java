package IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class iodemo {
	private static final  String LINE_SEPARATOR =System.getProperty("line.separator");
	public static void main(String[] args) throws IOException{
//		 FileWriter fw = new FileWriter("demo.txt",true);//构造函数加true 可以实现对文件的续写
//		 fw.write("abcd"+LINE_SEPARATOR+"hahahaha");
//		 fw.write("xixi");
//		 fw.flush();
//		 fw.close();

//		File f = new File("D:\\demo3.txt");//创建文件
//		f.createNewFile();
//		

//		System.out.println(File.separator);//常量 
//		System.out.println(File.pathSeparator);//

//		String filename = "D:\\demo3.txt";//删除文件
//		File f = new File(filename);
//		f.delete();

//		String dirname = "D:\\aabb"; //创建文件夹
//		File f = new File(dirname);
//		f.mkdir();


//		String filename = "D:"+File.separator;
//		File f = new File(filename);
//		String[] str = f.list();//列出目录的全部文件
//		File[] str1 = f.listFiles();//列出目录的全部文件（包含隐藏文件）
//		for(File li:str1){
//			System.out.println(li);
//		}

//		String filename = "D:\\server";//列出目录所有文件
//		File f = new File(filename);
//		print(f);
//	}
//	private static void print(File f) {
//		if(f!=null){
//			if(f.isDirectory()){
//				File[] fileArray = f.listFiles();
//				if(fileArray!=null){
//					for(File li:fileArray){
//						print(li);
//					}
//				}
//			}else{
//				System.out.println(f);
//			}
//		}

//		String filename = "D:"+File.separator+"demo3.txt";
//		File f = new File(filename);
//		RandomAccessFile demo = new RandomAccessFile(f,"rw");
//		demo.writeBytes("asdfas");
//		demo.writeInt(12);
//		demo.writeBoolean(true);
//		demo.writeChar('A');
//		demo.writeFloat(1.21f);
//		demo.writeDouble(12.123);
//		demo.close();


//		String filename = "D:"+File.separator+"demo4.txt";//字节流写入
//		File f = new File(filename);
//		OutputStream out = new FileOutputStream(f);
//		String str = "了刷卡的房间辣设计费啦";
//		byte[] b = str.getBytes();
//		out.write(b);
//		out.close();


//		String filename = "D:"+File.separator+"demo4.txt";//字节流读取
//		File f = new File(filename);
//		InputStream in = new FileInputStream(f);
//		byte[] b = new byte[1024];
//		//byte[] b = new byte[(int)f.length()];
//		int len =in.read(b);
//		in.close();
//		//System.out.println(new String(b));
//		System.out.println(new String(b,0,len));

//		String filename = "D:"+File.separator+"demo5.txt";//字符流写入
//		File f = new File(filename);
//		Writer out = new FileWriter(f);
//		String str = "啥的了进决赛了，生活费卡死机吗";
//		out.write(str);
//		out.close();

//		String filename = "D:"+File.separator+"demo5.txt";//字符流读取
//		File f = new File(filename);
//		char[] ch = new char[1024];
//		Reader read = new FileReader(f);
//		int count;
//		while((count=read.read(ch))!=-1){
//		System.out.println(new String(ch,0,count));
//		}



	}
}
