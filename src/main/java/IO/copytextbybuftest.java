package IO;

import java.io.*;

public class copytextbybuftest {
	public static void main(String[] args) throws IOException{
		
	FileReader fr = new FileReader("demo.txt");
	BufferedReader bufr = new BufferedReader(fr);
	
	FileWriter fw = new FileWriter("demo-2.txt");
	BufferedWriter bufw = new BufferedWriter(fw);
	
	String line = null;
	while((line=bufr.readLine())!=null){
		bufw.write(line);
		bufw.newLine();
		bufw.flush();
	}
	bufw.close();
	bufr.close();
	}
}
