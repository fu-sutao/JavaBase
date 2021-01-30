package com.fst.jvm;

import org.junit.Test;

public class ChPool {
    @Test
    public void a1(){
        Integer a = 12;
        Integer c = 12;//在常量池内创建，所以两个12都为同一个地址，当大于127后则在堆内创建
        Integer d = 232;
        Integer e = 232;
        System.out.println(a==c);
        System.out.println(d==e);
        //相同内容常量池中永远只有一份，基本数据类型、
        // 对象的引用都存在栈中，执行速度快，包装类型，
        // 对象存储，new出来的对象都是存储在堆中
        //Byte,Short,Integer,Long,Character这5种
        // 整型的包装类只是在对应值小于等于127时才可使用对象池。
        // 超过了就会自动申请空间创建对象，

        String b = "aadd";
        System.out.println(b.hashCode());
    }
}
