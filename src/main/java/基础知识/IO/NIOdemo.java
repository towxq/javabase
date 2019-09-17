package 基础知识.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

public class NIOdemo
{
    public static void main(String[] args){

    }

    public static void fastcopy(String src,String dist) throws IOException {
        //获取文件的输入字节流
        FileInputStream fileInputStream = new FileInputStream(src);
        //获取输入字节流的文件通道
        FileChannel fcin = fileInputStream.getChannel();

        //获取输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(dist);
        //获取输出字节流的通道
        FileChannel fcout = fileInputStream.getChannel();

        //为缓冲区分配1024字节
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        while(true){
            //输入管道读取到缓冲区
            int r = fcin.read(byteBuffer);

            //read返回-1表示读完
            if(r==-1){
                break;
            }

            //切换读写
            byteBuffer.flip();
            //缓冲区的内容写入输出文件中
            fcout.write(byteBuffer);
            //清空缓冲区
            byteBuffer.clear();
        }
    }
}

//NIO                         IO
//面向缓冲                  面向流
//同步非阻塞                同步阻塞
//选择器（多路复用）         无

//NIO的三大核心组件
//1，通道（channel）
//2，缓冲（Buffer）
//3，选择器（Selector）
//
//1，面向缓冲
//    传统IO面向流，NIO面向缓冲，传统IO每次从流中读一个或者多个字节，直到读取所有的字节，他们没有被缓存到任地方，此外不能前后移动流中的数据
//    NIO是将数据读取到一个它稍后处理的缓冲区，需要时可以在缓冲区中前后移动，增加了处理中的灵活性
//
//2，同步非堵塞
//    传统的IO流是堵塞的，当一个线程调用read或者write时，该线程被阻塞，直到数据完成所有的读取或者写入完成
//    NIO是非阻塞的，一个线程从某通道发送请求读取数据，但是它仅可得到目前可用的数据，如果目前没有可用的数据时，什么都不获取，而不是保持线程阻塞，直到数据变得可以读取之前，
//    该线程可以继续处理其他的事情
//
//3，多路复用
//    多路复用是指，单线程也可以通过轮询监控的方式实现多线程类似的结果，简单的说就是，通过选择机制，使用一个单独的线程来管理多个通道
//
//
//
//通道（Channel）
//    channel是传统IO中的Stream的升级版，Stream是单向的，读写分离，Channel是双向的，可以用来写也可以读
//
//
//        Channel <--->  Buffer <----->Channel
//
//缓冲（Buffer）
//    Buffer可以理解为一块内存区域，可以写入数据，并且在之后的读取，这快内存被包装成NIO buffer对象，它提供一些方法来简单的操作内存


//选择器（Selector）
//    可以实现一个单独的线程来监控多个注册在她上面的通道，通过一定的选择机制，实现多路复用的效果
//
//                      Thread
//                        |
//                        |
//                      Selector
//                    /    |    \
//                /        |      \
//            Channel    Channel    Channel

