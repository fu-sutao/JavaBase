package com.fst.reflex;

public class Test_reflect {
    public static void main(){
        Test_reflect t = new Test_reflect();

    }


    private int a = 100;
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


    public Test_reflect(){
        System.out.println("私有构造函数被调用");
    }
    private Test_reflect(int b){
        System.out.println("私有有参构造函数被调用"+b);
    }
    private void function1(int a){
        System.out.println("私有方法被调用"+a);
    }
}
