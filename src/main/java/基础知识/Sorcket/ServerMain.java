package 基础知识.Sorcket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args)  {

        //option+command+t
        try {
            //1、初始化服务端socket并且绑定9999端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //2、开始监听，等待客户端的连接
            System.out.println("***服务器即将启动，等待客户端的连接***");
            Socket socket = null;


            //记录客户端的数量
            int count = 0;

            //循环监听等待客户端的连接
            while (true){
                //调用accept等待客户端的连接
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                //启动线程
                serverThread.start();
                count++;
                System.out.println("客户端的数量："+count);

                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的ip地址："+address.getHostAddress());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
