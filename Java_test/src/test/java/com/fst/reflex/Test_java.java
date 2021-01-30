package com.fst.reflex;

import com.fst.designmodel.Dan_li;
import com.fst.designmodel.Test_JavaBean;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test_java {
    @Test
    public void mathod(){
        Random random = new Random();
    }
    @Test
    public void mathod2(){
        long time1 = System.currentTimeMillis();
        int a = 1;
        System.out.println("系统时间是"+time1);
        for(int i = 0;i < 1000000;i++){

        }
        long tima2 = System.currentTimeMillis();
        System.out.println("系统时间是"+tima2);
        System.out.println("时间差是 = "+(tima2-time1));
    }
    //read all file FileInputStream
    @Test
    public void mathod3() throws Exception {
        FileInputStream file = new FileInputStream("D:/IO/my.png");
        byte  bytes[] = new byte[1024];
        String temp = null;
        //89504e47
        while ((file.read(bytes,0,bytes.length))!=-1){
            for(int i = 0; i < bytes.length;i++){
                int a = bytes[i]&0xff;//转化为无符号类型
                //当数值低于16亿后前面补零
                if(a<16){
                    temp = "0"+Integer.toHexString(a);
                   // System.out.print("前面0："+temp);
                }else {
                    temp = Integer.toHexString(a);
                }
                System.out.print(temp);
            }
        }
    }

    @Test
    public void readFromByteFile() throws IOException {
        File filename = new File("D:\\my.png");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] temp = new byte[1024];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            out.write(temp, 0, size);
            for(int i = 0;i < 1024; i++){
                System.out.print(temp[i]);
            }
        }
        in.close();
        byte[] content = out.toByteArray();
        System.out.println(content);
        //return content;
    }
    //写文件流 和读文件流。
    @Test
    public void writeFile() throws IOException {
        File file = new File("D:/IO/as.png");
        File file1 = new File("D:/IO/as.txt");
        String temp = null;
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        if(file1.exists()){
            file1.delete();
        }
        file1.createNewFile();
        //定义流
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream fileInputStream =new FileInputStream("D:/IO/info.txt");
            FileWriter fileWriter = new FileWriter(file1);
        ) {
//          定义一个字节数组用于缓冲
            byte [] bytes = new byte[5];
            //copy wenjan
            while ((fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
                //把文件转化成16进制字符存入文件
                for(int i=0;i<bytes.length;i++){
                    int a = bytes[i]&0xff;//转化成无符号类型
                    if(a<16){
                        temp = "0"+Integer.toHexString(a);
                        fileWriter.write(temp);
                    }else {
                        temp = Integer.toHexString(a);
                        fileWriter.write(temp);
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void File1(){
        /**
         * .当前目录
         * ..上级目录
         * /=\\但是最好用/ 因为\在java中第一个转义第二个表示路径  在linux中都用/ window也能
         * 识别/
         */
        File file = new File("D:\\文档");
        System.out.println(file.canRead());//true
        System.out.println(file.toString());//D:\文档
        System.out.println(file.canWrite());//true
        System.out.println(file.exists());//true
        System.out.println(file.getAbsolutePath());//D:\文档
        System.out.println(file.getName());//文档
        System.out.println(file.getParent());//D:\
        System.out.println(file.getPath());//D:\文档
        System.out.println(file.isFile());//false  特殊文件和目录返回false
        System.out.println(file.isDirectory());//true
        System.out.println(file.length());//12288gtg返回由此抽象路径名表示的文件的长度。 如果此路径名表示目录，则返回值未指定。
        System.out.println(file.isAbsolute());//是否是绝对路径
        System.out.println(file.isHidden());//false
        //System.out.println(file.setReadOnly());
        //System.out.println(file.setLastModified());
        String s [] = file.list();
        for (int i = 0;i < s.length;i++){
            System.out.println(s[i]);
        }
        //file.mkdirs();创建目录
        System.out.println();
       // file.renameTo(File is)//重命名
    }
    @Test
    public void FileInputString1(){
        File file =new File("");
        int numb = 8;
        //D:/IO/info.txt 233字节
        //ce c4 bc fe b6 c1 c8 a1
        //D:/IO/my.png
        if(file.exists()){
            try (FileInputStream f = new FileInputStream("D:/IO/info.txt")){
                byte by[] = new byte[numb];
                String temp = null;
                //第二次读取会从对一次读取的后面开始读
                /**
                 * f.read(by,0,20);
                 * 以字节形式读取到字节组中，默认为有符号类型
                 * 如果直接用Integer转化成16进制，则206 = ffffffce
                 * len（read第三个参数）为单次读入字节数组中字节数一般等于数组大小
                 */
                for(int i = 0; i < by.length;i++){
                    int a = by[i]&0xff;//转化为无符号类型
                    if(a<16){
                        temp = temp +"0"+Integer.toHexString(a);
                    }else {
                        temp = temp + Integer.toHexString(a);
                    }
                }
                System.out.print(temp);
//            int a = f.available();//返回从此输入流中可以读取（或跳过）的剩余字节数的估计值
//            System.out.println(f.available());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //容器
    @Test
    public void arrayList1(){
        ArrayList<Test_JavaBean> arrayList = new ArrayList();
        arrayList.add(new Test_JavaBean(11,23,"a","b"));
        arrayList.add(new Test_JavaBean(32,32,"s","y"));
        arrayList.add(new Test_JavaBean(15,24,"e","j"));
        arrayList.add(new Test_JavaBean(13,62,"f","j"));
        arrayList.add(new Test_JavaBean(61,27,"y","a"));
        //for foreach循环遍历
        for (Test_JavaBean test_javaBean : arrayList) {
            //System.out.println(test_javaBean.getId());
        }
        //转化成数组
        Test_JavaBean [] test_javaBeans = new Test_JavaBean[arrayList.size()];
        test_javaBeans = arrayList.toArray(test_javaBeans);//将arraylist转化成数组遍历
        for(int i=0;i<test_javaBeans.length;i++){
            //System.out.println(test_javaBeans[i].getId());
        }
        //使用迭代器
        Iterator<Test_JavaBean> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getId());
        }

    }
    public void Vector1(){
        Vector<Test_JavaBean> vector = new Vector();
        vector.add(new Test_JavaBean(11,23,"a","b"));
        vector.add(new Test_JavaBean(32,32,"s","y"));
        vector.add(new Test_JavaBean(15,24,"e","j"));
        vector.add(new Test_JavaBean(13,62,"f","j"));
        vector.add(new Test_JavaBean(61,27,"y","a"));
        //遍历方法同上



    }
    public void linkedList(){
        LinkedList<Test_JavaBean> linkedList = new LinkedList();
        linkedList.add(new Test_JavaBean(11,23,"a","b"));
        linkedList.add(new Test_JavaBean(32,32,"s","y"));
        linkedList.add(new Test_JavaBean(15,24,"e","j"));
        linkedList.add(new Test_JavaBean(13,62,"f","j"));
        linkedList.add(new Test_JavaBean(61,27,"y","a"));
        //遍历方案用for循环
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i).getId());
        }
        //转成数组

    }
    @Test
    public void shuzu(){
        int [] a = new int [10];
        a[1]=10;
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList.size());//返回的是实际存放数据的量
        System.out.println(a.length);//返回数组定义长度

    }
    @Test
    public void String1(){
        String a = "aa";
        String b = "aa";
        String c = new String ("as");
        String d = "as";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());

    }
    //主要用于获取一个类的私有方法或者属性
    //反射类
    @Test
    public void reflectClass() {
        //public 在任何地方都能访问
        //private 只有在本类中才能访问
        //protected，本类同包和子类能访问
        //都不写默认public
        //final 不能够被继承
        try {
            Class<?> c = Class.forName("com.fst.designmodel.Test_reflect");
            Object testReflect = c.newInstance();//构造函数为公有可以这样调用。如果为私有则抛出异常
            Test_reflect test_reflect = (Test_reflect) testReflect;
            //通过反射已经拿到引用 ，此时里面的公共的方法和属性可以访问。
            int a = test_reflect.getA();
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //反射构造函数
    @Test
    public void reflectConstructor(){
        try {
            Class<?> c = Class.forName("com.fst.designmodel.Test_reflect");
            //设置构造函数传参类型
            Constructor<?> d = c.getDeclaredConstructor(int.class);
            d.setAccessible(true);
            //传入构造函数的参数
            Object testreflect = d.newInstance(2);
            Test_reflect m = (Test_reflect) testreflect;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射成员变量
    @Test
    public void reflectField (){
        try {
            Class<?> c = Class.forName("com.fst.designmodel.Test_reflect");
            Object objectBook = c.newInstance();
            //要反射的成员变量名  a
            Field fieldTag = c.getDeclaredField("a");
            fieldTag.setAccessible(true);
            int tag = (int) fieldTag.get(objectBook);
            System.out.println(tag);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //反射方法
    @Test
    public void reflectmethod(){
        try {
            Class<?> c = Class.forName("com.fst.designmodel.Test_reflect");
            Object object = c.newInstance();
            Method method = c.getDeclaredMethod("function1",int.class);
            method.setAccessible(true);
            //如果方法有返回值在前面加返回值并强制转换
            method.invoke(object,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void danli(){


        Dan_li.getSingleton();
    }


}


