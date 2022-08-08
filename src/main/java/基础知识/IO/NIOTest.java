package 基础知识.IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wxq
 * @ClassName NIOTest
 * @Description TODO
 * @date 2021/10/15  10:46
 */
public class NIOTest {
    public static void main(String[] args) throws IOException {
        NioTest("E:\\demo2.txt", "E:\\demo3.txt");
    }
    public static void NioTest(String file, String file2) throws IOException {
        FileChannel channel1 = new FileInputStream(file).getChannel();
        FileChannel channel2 = new FileOutputStream(file2).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while(true) {
            int i = channel1.read(byteBuffer);
            if (i == -1) {
                break;
            }
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.clear();
        }
        channel1.close();
        channel2.close();
    }
}
