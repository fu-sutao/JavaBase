package com.fst.design_model.principle;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.xml.internal.ws.message.saaj.SAAJMessage;

/**
 * 接口隔离原则
 */
public class Segregation {
    public static void main(String[] args) {
        C c = new C();
        B b1 = new B();
        Inter b = new B();
        c.depend1(b);
    }


}
//接口
interface Inter{
    void m1();
    void m2();
    void m3();
    void m4();
    void m5();

}
class B extends A implements Inter{

    @Override
    public void m1() {
        System.out.println("B实现了方法1");
    }

    @Override
    public void m2() {
        System.out.println("B实现了方法2");
    }

    @Override
    public void m3() {
        System.out.println("B实现了方法3");
    }

    @Override
    public void m4() {
        System.out.println("B实现了方法4");
    }

    @Override
    public void m5() {
        System.out.println("B实现了方法5");
    }
}
class D implements Inter{
    @Override
    public void m1() {
        System.out.println("D实现了方法1");
    }

    @Override
    public void m2() {
        System.out.println("D实现了方法2");
    }

    @Override
    public void m3() {
        System.out.println("D实现了方法3");
    }

    @Override
    public void m4() {
        System.out.println("D实现了方法4");
    }

    @Override
    public void m5() {
        System.out.println("D实现了方法5");
    }
}
class A {//A通过接口依赖（使用）B类，但是只使用123方法
    public void depend1(Inter i){
        i.m1();
    }
    public void depend2(Inter i){
        i.m2();
    }
    public void depend3(Inter i){
        i.m3();
    }
}

class C{//A通过接口依赖（使用）D类，但是只使用123方法
    public void depend1(Inter i){
        i.m1();
    }
    public void depend4(Inter i){
        i.m4();
    }
    public void depend5(Inter i){
        i.m5();
    }
}

















