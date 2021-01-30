package com.fst.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 1缓冲区（buffer）：在javaNIo中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 4·缓冲区四个核心属性
 *  private int mark = -1;
 *  private int position = 0;表示缓冲区正在操作的数据位置
 *  private int limit;     ：界限 表示缓冲区中可以操作的数据的大小（limit）
 *  private int capacity;  : 容量 表示缓冲区最大储存容量。一旦声明不能改变。
 *
 *  0 <= mark <= position <= limit <= capacity
 *  5·直接缓冲区与非直接缓冲区
 *  非直接缓冲区：通过allocate() 方法分配缓冲区，将缓冲区建立在jvm的内存中
 *  直接缓冲区：通过allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率。
 */
public class NIO1 {
    @Test
    public void test1(){
        String string = "abcde";
        //分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //string.getBytes()将字符串改造成字符数组
        System.out.println("放数据前");//当前位置
        System.out.println(buffer.position());//当前位置
        System.out.println(buffer.limit());    //可操作数据大小
        System.out.println(buffer.capacity());//容量
        //往缓冲区写入数据
        buffer.put(string.getBytes());

        System.out.println("放数据后");//当前位置
        System.out.println(buffer.position());//当前位置
        System.out.println(buffer.limit());    //可操作数据大小
        System.out.println(buffer.capacity());//容量
        //切换到
        buffer.flip();
        System.out.println("位置："+buffer.position());
        System.out.println("可操作数据大小改变"+buffer.limit());    //可操作数据大小
        System.out.println("容量："+buffer.capacity());

        //
        byte []dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("位置："+buffer.position());
        System.out.println("可操作数据大小改变"+buffer.limit());    //可操作数据大小
        System.out.println("容量："+buffer.capacity());

        //可重复读取数据
        buffer.rewind();
        System.out.println("位置："+buffer.position());
        System.out.println("可操作数据大小改变"+buffer.limit());    //可操作数据大小
        System.out.println("容量："+buffer.capacity());

        //清空缓冲区 但是里面的数据依然存在，但是出于被遗忘状态
        buffer.clear();
        System.out.println("位置："+buffer.position());
        System.out.println("可操作数据大小改变"+buffer.limit());    //可操作数据大小
        System.out.println("容量："+buffer.capacity());
        System.out.println((char) buffer.get());
    }
    @Test
    public void test2(){
        String str = "abcd";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte [] dst = new byte[buffer.limit()];
        buffer.get(dst,0,2);//从0开始读两个字符
        System.out.println(buffer.position());//当前位置
        System.out.println(buffer.limit());    //可操作数据大小
        System.out.println(buffer.capacity());//容量
        System.out.println(new String(dst,0,2));
        //mark() : 标记
        buffer.mark();
        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position());//当前位置

        //恢复到标记位置
        buffer.reset();
        System.out.println(buffer.position());//当前位置

        //判断缓冲区是否还有剩余数据
        if(buffer.hasRemaining()){
            //获取缓冲区中可操作的数量
            System.out.println(buffer.remaining());
        }


    }
    @Test
    public void test(){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        //判断是否是直接缓冲区
        System.out.println(buffer.isDirect());
    }

}






























