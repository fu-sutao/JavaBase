package com.fst.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用NIO完成网络通信的三个核心
 *
 * 1·通道 ： 负责连接
 * 2·缓冲区 ： 负责数据存取
 * 3·选择器（Selector） ： 是SelectorChannel的多路复用器。用于监控SelectableChannel的IO的状况
 *
 */
public class BlockingNIO {
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel channel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        //分配指定大小的缓冲区域
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取本地文件并发送到服务器
        while(channel.write(buf)!=-1){
            buf.flip();
            sc.write(buf);
            buf.clear();
        }
        //关闭通道
        channel.close();
        sc.close();

    }
    @Test
    public void server ()throws IOException{
        //获取通道
        ServerSocketChannel ss = ServerSocketChannel.open();
        //绑定连接
        FileChannel channel = FileChannel.open(Paths.get(""),
                StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ss.bind(new InetSocketAddress(9989));
        //获取连接通道
        SocketChannel socketChannel = ss.accept();

        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //接受客户端数据 并保存到本地
        while(socketChannel.read(buffer) != -1){
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        //关闭通道 和 连接
        socketChannel.close();
        channel.close();
        ss.close();


    }

}






