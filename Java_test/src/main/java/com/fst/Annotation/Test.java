package com.fst.Annotation;

public class Test {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}
class A{
    /**
     * 1·加载到内存产生一个class对象
     * 2·连接后m=0
     * 3·初始化
     * <clinit>(){
     *     m = 100;
     *     System.out.println("静态代码块被初始化");
     *     m = 300;
     * }
     */
    static int m = 100;
    static {
        System.out.println("静态代码块被初始化");
        m = 300;//谁在前谁先执行
    }

    public A() {
        System.out.println("构造函数初始化");
    }
}