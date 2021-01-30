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

public class BlockNIO {
    @Test
    public void client() throws IOException{
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel inChannel = FileChannel.open(Paths.get("0"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer) != -1){
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }
        //接受服务器反馈
        int len  = 0 ;
        while((len = sChannel.read(buffer))!=1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        inChannel.close();
        sChannel.close();

    }
    @Test
    public void server()throws IOException{
        ServerSocketChannel sschannel = ServerSocketChannel.open();
        FileChannel out = FileChannel.open(Paths.get(""),
                StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        sschannel.bind(new InetSocketAddress(9898));
        SocketChannel schannel = sschannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (schannel.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        //发送反馈给客户端
        buffer.put("服务端接受数据成功".getBytes());
        buffer.flip();
        schannel.write(buffer);
        out.close();
        schannel.close();
        sschannel.close();

    }



}
