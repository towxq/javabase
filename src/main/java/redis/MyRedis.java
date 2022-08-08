package redis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wxq
 * @ClassName MyRedis
 * @Description TODO
 * @date 2021/8/20  14:14
 */
public class MyRedis {
    //假的redis
    //支持多个用户访问？  tomcat6.X之前是多线程
    static List<Socket> socketList = new ArrayList<>();
    static byte[] bs= new byte[1024];



    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        while(true){
            System.out.println("等待连接。。。。。。");
            Socket accept = serverSocket.accept();//阻塞

//            System.out.println("等待数据。。。。。。");
//            accept.getInputStream().read(bs);//阻塞
//            System.out.println("获取数据。。。。");
//            System.out.println(new String(bs));


            new Thread(()->{
                try {
                    accept.getInputStream().read(bs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(bs));
            }).start();


        }
    }
}
