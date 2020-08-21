package 基础知识.IO;

import java.io.*;

public class IODemo {
        public static void main(String[] args) throws IOException {

//            FileInputStream fileInputStream = new FileInputStream("D://aa.txt");
//            InputStream inputStream = new BufferedInputStream(fileInputStream);

//            int i = 0;
//            while ((i=fileInputStream.read())!=-1){
//                System.out.print((char)i);
//            }
//            fileInputStream.close();

//            byte[] bytes = new byte[1024];
//            int i = 0;
//            while((i = fileInputStream.read(bytes))!=-1){
//                System.out.print(new String(bytes,0,i));
//            }
//            fileInputStream.close();


//            OutputStream outputStream = new FileOutputStream("D://bb.txt");
//            outputStream.write("sadsadasd".getBytes());
//            outputStream.write("\r\n".getBytes());
//            outputStream.write("21312312casdasdsadasd".getBytes());
//            outputStream.close();

//              byte[] bytes = new byte[1024];
//              int len = 0;
//              while((len=inputStream.read(bytes))!=-1){
//                  System.out.print(new String(bytes,0,len));
//              }
//              inputStream.close();

//             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("D://cc.txt"));
//             outputStream.write("asdasdasd".getBytes());
//             outputStream.write("\r\n".getBytes());
//             outputStream.write("阿达sadasdasdad".getBytes());
//             outputStream.close();
//
//             InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D://ee.txt"),"utf-8");
//             int len = 0;
//             while((len = inputStreamReader.read())!=-1){
//                 System.out.print((char) len);
//             }
//             inputStreamReader.close();


//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D://ee.txt"),"utf-8"));
//            String str;
//            while((str = bufferedReader.readLine())!=null){
//                System.out.println(str);
//            }
//            bufferedReader.close();


//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://ff.txt"),"utf-8"));
//            bufferedWriter.write("sadssadasd阿萨德");
//            bufferedWriter.write("\r\n");
//            bufferedWriter.write("sadasdsad太感人");
//            bufferedWriter.close();


//            FileReader fileReader = new FileReader("D://aa.txt");
//            int len = 0;
//             while((len = fileReader.read())!=-1){
//                 System.out.print((char) len);
//             }
//            fileReader.close();

//             FileInputStream fileInputStream1 = new FileInputStream("D://001.png");
//             FileOutputStream fileOutputStream = new FileOutputStream("D://002.png");
//             byte[] bytes = new byte[1024];
//             int len = 0;
//             while((len = fileInputStream1.read(bytes))!=-1){
//                 fileOutputStream.write(bytes,0,len);
//             }
//             fileInputStream1.close();
//             fileOutputStream.close();


//             BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream("D://2.mov"));
//             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("G://2.mov"));
//             int len = 0;
//             byte[] bytes = new byte[1024];
//             while((len = inputStream1.read(bytes))!=-1){
//                 outputStream.write(bytes,0,len);
//             }
//             inputStream1.close();
//             outputStream.close();
             BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
             String s = null;
             s = bufferedReader.readLine();
             while (s!=null){
                 if (s.equalsIgnoreCase("exit")) break;
                 System.out.println(s.toUpperCase());
                 s = bufferedReader.readLine();
             }
             bufferedReader.close();
        }
}




//                                            FileInputStream
//                    InputStream字节输入流
//                                            BufferedInputStream
//        字节流
//                                            FileOutputStream
//                    OutputStream字节输出流
//  IO                                        BufferedOutputStream
//
//                                            InputStreamReader转换流    FileReader
//                    Reader字符输入流
//                                            BufferedReader
//        字符流
//                                            OutputStreamWriter转换流   FileWriter
//                    Writer字符输出流
//                                            BufferedWriter