package com.fst.design_model.principle;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class Liskov {
    public static void main(String[] args) {
        new A3();

        B3 b3 = new B3();
        b3.function(1,4);//本意是想调用父类中的function
    }
}
class A3{
    int function(int a,int b){
        return a+b;
    }
}
class B3 extends A3{
    //无意中进行了重写
    int function(int a,int b){
        return a-b;
    }
    int function1(int a,int b){
        return a-b+4;
    }
}
//修改方案如下
class Base3 extends AALOAD {
    //更加基础的类
}
class A33 extends Base3{
    int function(int a,int b){
        return a+b;
    }
}
class B33 extends Base3 {
    //无意中进行了重写
    private A33 a33 = new A33();

    int function(int a, int b) {
        return a - b;
    }

    int function1(int a, int b) {
        return a - b + 4;
    }
    //仍然想用a的方法  组合法
    int function2(int a, int b) {
        return this.a33.function(a,b);
    }
}















