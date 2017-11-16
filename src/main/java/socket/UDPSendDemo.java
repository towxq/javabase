package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("发送端启动.........");
			/*
			 * 创建udp传输的发送端
			 * 思路
			 * 1，建立udp的socket服务
			 * 2，将要发送的数据装到数据包中
			 * 3，通过udp的socket服务将数据包发送出去
			 * 4，关闭socket服务
			 */
		//1，udpsocket服务，使用DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(8888);
		//2,将要发送的数据封装到数据包中来
		String str = "UDP传输：im here!";
		//使用DatagramPacket将数据装到该对象中
		byte[] buf = str.getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.117"),10000);
		//3,通过udp的socket服务将数据包发送出去，使用send方法
		ds.send(dp);
		//4,关闭资源
		ds.close();
	}

}
