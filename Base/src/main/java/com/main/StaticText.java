package com.main;

public class StaticText {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        System.out.println(a.b.hashCode()==b.b.hashCode());
        System.out.println();

    }

}
class A{
    public static
    B b = new B();

}
class B{
    public B(){
        System.out.println("bb");
    }
}
