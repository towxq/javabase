package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动......");

		//1，建立udp socket服务
		DatagramSocket ds = new DatagramSocket(10000);

		while(true){
			//2,创建数据包
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			//3，使用接收方法将数据存储到数据包中
			ds.receive(dp);

			//4,通过数据包对象的方法，解析其中的数据
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(),0,dp.getLength());
			System.out.print(ip+":"+port+":"+text);
		}
	}

}
