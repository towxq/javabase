package 基础知识.Sorcket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("sadasd");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        socket.close();

        System.in.read();
    }
}
