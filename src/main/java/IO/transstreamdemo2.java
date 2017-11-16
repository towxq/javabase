package IO;

import java.io.*;

public class transstreamdemo2 {
		public static void main(String[] args) throws IOException{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
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
