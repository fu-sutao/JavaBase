package com.fst.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一，通道（Channel）：用于源节点与目标节点的连接。在Java中NIO中负责缓冲区数据的传输。
 * Channel本身不存储数据，因此要配合缓冲区进行传输。
 * 二、通道主要实现的类
 * java.nio.channels.Channel 接口：
 *   --FileChannel
 *   --SocketChannel
 *   --ServerSocketChannel
 *   --DatagramChannel
 * 三、获取通道
 * 1·Java 针对通道类提供了getChannel（）方法
 *  --FileInputStream/FileOutputStream
 *
 *  网络IO
 *  Socket
 *  ServiceSocket
 *  DatagramSocket
 * 2·在JDK 1.7中的NIO.2针对各个通道提供了静态方法open（）
 * 3·在JDK 1.7中的NIO.2的File工具类newByteChannel（）
 * 四、通道之间数据传输
 * transfertoFrom（）
 * transferTo（）
 * 五 分散（）与聚集
 * 分散读取Scattering Reads：将通道中的多个数据分散到多个缓冲区
 * 聚集写入Gathring Writes：将多个分散通道中的数据聚集写入到通道中
 * 六、字符集Charset
 * 编码： 字符串=》字节数组
 * 解码：字节数组=》字符串
 */
public class Channel {
    //利用通道完成文件复制
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel in = null;
        FileChannel out = null;
        //完成文件的复制
        try {
            fis = new FileInputStream("");
            fos = new FileOutputStream("");

            //获取通道
            in = fis.getChannel();
            out = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);//也可以使用直接缓存区
            //
            while (in.read(buffer)!=-1){
                buffer.flip();//切换到读取数据模式
                //将缓冲区中的数据存入到通道中
                int write = out.write(buffer);
                buffer.clear(); //清空缓冲区
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
                fis.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }



    }

    @Test
    public void test2() throws IOException {
        FileChannel in = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get(""),StandardOpenOption.READ,
                StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);
        //第三个参数表示没有就创建，有就抛出异常 如果CREATE则没有就创建，有就覆盖。
        //内存映射文件
        MappedByteBuffer mappedByteBuffer = in.map(FileChannel.MapMode.READ_ONLY,0,in.size());
        MappedByteBuffer mappedByteBuffer1 = out.map(FileChannel.MapMode.READ_WRITE,0,out.size());

        //直接对缓冲区进行读写操作
        byte[] dst = new byte[mappedByteBuffer.limit()];
        mappedByteBuffer.get(dst);
        mappedByteBuffer1.put(dst);
        in.close();
        out.close();

    }

    @Test
    public void test3() throws IOException{
        FileChannel in = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get(""),StandardOpenOption.READ,
                StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);
        in.transferTo(0,in.size(),out);
        //out.transferFrom(out,0,in.size());
        in.close();
        out.close();
    }

    @Test
    public void test4() throws IOException{
        //分散和聚集
        RandomAccessFile raf1 = new RandomAccessFile("1.txt","rw");
        //获取通道
        FileChannel channel = raf1.getChannel();

        //2·分散指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3·分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel.read(bufs);

        for(ByteBuffer buffer : bufs){
            buffer.flip();

        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));

        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.t","");
        FileChannel channel1 = raf2.getChannel();

        channel1.write(bufs);
        channel1.close();
    }

    @Test
    public void test5(){
        Map<String,Charset> map=Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set = map.entrySet();
        for(Map.Entry<String,Charset> enty : set){
            System.out.println(enty.getKey() + "=" +enty.getValue());
        }

    }
    @Test
    //字符集
    public void test6 () throws IOException{
        //
        Charset charset = Charset.forName("GBK");
        //拿到编码器与解码器
        CharsetEncoder ce = charset.newEncoder();
        CharsetDecoder de = charset.newDecoder();

        CharBuffer cb = CharBuffer.allocate(1024);
        cb.put("尚硅谷八点是");
        cb.flip();
        //编码
        ByteBuffer buffer = ce.encode(cb);

        for(int i =0;i<12;i++){
            System.out.println(buffer.get());
        }
        //解码
        buffer.flip();
        CharBuffer buffer1 = de.decode(buffer);
        System.out.println(buffer1.toString());
    }
    @Test
    public void test7(){

    }


}



























