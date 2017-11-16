package socket;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatDemo {
	public static void main(String[] args) throws IOException{
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();
	}
}
