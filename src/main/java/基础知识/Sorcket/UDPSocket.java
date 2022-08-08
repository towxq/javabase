package 基础知识.Sorcket;

import java.io.IOException;
import java.net.*;

/**
 * @author wxq
 * @ClassName UDPSocket
 * @Description TODO
 * @date 2021/10/14  16:06
 */
public class UDPSocket {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "hello udp".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),8877);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
