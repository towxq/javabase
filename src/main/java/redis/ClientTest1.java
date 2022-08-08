package redis;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wxq
 * @ClassName ClientTest
 * @Description TODO
 * @date 2021/8/20  14:20
 */
public class ClientTest1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6379);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        socket.getOutputStream().write(next.getBytes());
        socket.close();
    }
}
