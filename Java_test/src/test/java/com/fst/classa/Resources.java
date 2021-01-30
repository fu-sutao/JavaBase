package com.fst.classa;
/**
 *
 *
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAstream(String e){
        return Resources.class.getClassLoader().getResourceAsStream(e);
    }
    @Test
    public void in() throws IOException {
//        Class c = Resources.class;
//        c.getResource("");
        InputStream in = getResourceAstream("peizhi.xml");

        //InputStream in = new FileInputStream("G:\\IDEA\\Java_test\\src\\main\\resources\\peizhi.xml");
        //定义一个数组相当于缓存
        byte by[]=new byte[1024];
        int n=0;
        while((n=in.read(by))!=-1)
        {
            String s=new String(by,0,n);
            System.out.println(s);
        }
    }
    //class类中的resolveName（String name）将字符串翻译成类全限定名  com.fst.Test.java
    @Test
    public void a(){
        //String a =Resources.class.getName();//返回com.fst.classa.Resources
        String a = resolveName("com.fst.Test.java");//com/fst/classa/com.fst.Test.java
        System.out.println(sun.misc.Launcher.getBootstrapClassPath());
    }
    //class中抽象方法分析   功能字符串处理
    private static String resolveName(String name) {
        if (name == null) {
            return name;
        }
        if (!name.startsWith("/")) {
            Class<?> c = Resources.class;
            while (c.isArray()) {
                c = c.getComponentType();
            }
            String baseName = c.getName();//com.fst.classa.Resources
            int index = baseName.lastIndexOf('.');
            //截取字符串com.fst.classa+/name
            if (index != -1) {
                name = baseName.substring(0, index).replace('.', '/')
                        +"/"+name;
            }
        } else {
            name = name.substring(1);
        }
        return name;
    }
    @Test
    public void Interint(){
        int a = 12;
        Integer b = 128;
        boolean c = a==b;
        //int and integer 怎么比都为true，说明int在-127~127以内也是存放在常量池中
        Integer d = 5;
        Integer e = new Integer(5);
        //e在堆中 d在常量池中
        Integer f = 128;
        Integer g = new Integer(128);
        //f g都存放与对中，为两个独立的对象。其地址不再相等。（常量池中每个值只有一份，堆中则不遵循这个规则）
        c = f==g;
        System.out.print(c);
    }
    @Test
    public void nulltest(){
        String a = "";//已经分配内存
        String b = null;//没有分配内存
        boolean c = a == b;
        System.out.println(a);
        System.out.print(b);
        System.out.println(c);

    }

}

