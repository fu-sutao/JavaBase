package com.fst.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class BlockNIO1 {
    //
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel s = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //切换到非阻塞模式
        s.configureBlocking(false);

        //分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //发送数据给服务器
        buf.put(new Date().toString().getBytes());
        buf.flip();
        s.write(buf);
        buf.clear();

        //关闭通道
        s.close();

    }
    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel ss = ServerSocketChannel.open();
        //切换到非阻塞模式
        ss.configureBlocking(false);
        //绑定连接
        ss.bind(new InetSocketAddress(9898));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上并且指定“监听接收事件”
        ss.register(selector, SelectionKey.OP_ACCEPT);
        //轮训式的获取选择器上已经“准备就绪”的事件
        while (selector.select()>0){
            //获取当前选择器中所有注册的选择键（已经就绪的监听事件）
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()){
                //获取准备就绪的事件
                SelectionKey sk = it.next();
                //判断是什么事件准备就绪
                if(sk.isAcceptable()){
                    //若接收准备就绪 获取客户端连接
                    SocketChannel s = ss.accept();
                    //切换到非阻塞模式
                    s.configureBlocking(false);
                    //将该通道注册到选择器上
                    s.register(selector,SelectionKey.OP_ACCEPT);
                }else if(sk.isReadable()){

                    SocketChannel sss = (SocketChannel) sk.channel();

                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = sss.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }


    }

    @Test
    public void send() throws IOException{
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String string = scanner.next();
            buffer.put((new Date().toString()+":\n"+string).getBytes());
            buffer.flip();
            dc.send(buffer,new InetSocketAddress("127.0.0.1",9898));
            buffer.clear();
        }
        dc.close();
    }
    @Test
    public void receive()throws IOException{
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(9898));
        Selector selector = Selector.open();
        dc.register(selector,SelectionKey.OP_ACCEPT);
        while(selector.select()>0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isReadable()){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    buffer.clear();
                }
            }
            it.remove();
        }

    }
    @Test
    public void pipe()throws IOException{
        Pipe pipe = Pipe.open();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buffer.put("zifuchaung".getBytes());
        buffer.flip();
        sinkChannel.write(buffer);




        //另一个线程
        Pipe.SourceChannel sourceChannel = pipe.source();
        buffer.flip();
        int len = sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();


    }
}

























