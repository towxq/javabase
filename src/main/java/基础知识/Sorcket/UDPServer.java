package 基础知识.Sorcket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wxq
 * @ClassName UDPServer
 * @Description TODO
 * @date 2021/10/14  16:11
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8877);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(bytes, 0, datagramPacket.getLength()));
        datagramSocket.close();
    }
}
