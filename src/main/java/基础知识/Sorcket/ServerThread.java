package 基础知识.Sorcket;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    //和本线程相关的socket
    Socket socket = null;

    public ServerThread(Socket socket) {

        this.socket = socket;
    }

    //线程执行操作，响应客户端的请求
    public void run() {
        //3、获取输入流，读取客户端所发出的信息
        InputStream is = null;//字节输入流
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);//将字节流转换为字符流
            br = new BufferedReader(isr);//为输入流添加缓冲
            String info = null;

            while ((info = br.readLine()) != null) {//循环读取客户端数据
                System.out.println("我是服务端，客户端说：" + info);
            }

            socket.shutdownInput();//关闭输入流
            //4.获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();//将缓冲输出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭资源
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
