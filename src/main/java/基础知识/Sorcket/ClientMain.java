package 基础知识.Sorcket;

import java.io.*;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {

        //1、创建客户端socket，指定服务器地址和端口号
        Socket socket = new Socket("localhost", 8888);
        //2、获取输出流，向服务端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流

        pw.write("用户名：adim22; 密码：123");
        pw.flush();
        socket.shutdownOutput();//关闭输出流

        //3、获取输入流，并读取服务端的响应信息
        InputStream is = socket.getInputStream();//字节输入流
        InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符流
        BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
        String info = null;
        while ((info = br.readLine())!=null){//循环读取客户端数据
            System.out.println("我是客户端，服务端说："+info);
        }

        //4、关闭资源
        is.close();
        isr.close();
        br.close();
        pw.close();
        os.close();
        socket.close();
    }
}
