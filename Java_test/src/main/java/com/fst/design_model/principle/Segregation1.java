package com.fst.design_model.principle;

/**
 * 接口隔离原则改进
 */
public class Segregation1 {

}
interface Inter1{
    void m1();
}
interface Inter2{
    void m1();
    void m2();
    void m3();
}
interface Inter3{
    void m4();
    void m5();
}
class B1 implements Inter1,Inter2{

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
}
class D1 implements Inter1,Inter3{
    @Override
    public void m1() {
        System.out.println("D实现了方法1");
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
class A1{//A通过接口依赖（使用）B类，但是只使用123方法
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

class C1{//A通过接口依赖（使用）D类，但是只使用123方法
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