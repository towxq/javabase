package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPdemo {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress ip = InetAddress.getLocalHost();
		ip = InetAddress.getByName("192.168.1.104");
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}
}