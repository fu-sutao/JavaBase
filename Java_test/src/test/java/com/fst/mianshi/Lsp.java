package com.fst.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * 子类完全拥有父类的方法，且具体子类必须实现父类的抽象方法。
 * 子类中可以增加自己的方法。
 * 当子类覆盖或实现父类的方法时，方法的形参要比父类方法的更为宽松。
 * 当子类覆盖或实现父类的方法时，方法的返回值要比父类更严格。
 */
public class Lsp {
    public void a(int a ,int b){

    }
}
class Lsp2 extends Lsp{

    static Number method(Number num) {
        Integer a = 1;
        return a;
    }
    static Son method1(Number num) {
        Father father = new Father();
        //
        //return father;
        return null;
    }
    static Father method3(Number num) {
        Son son =new Son();

        return son;
    }
    Object result = method(new Integer(2)); //correct
    //Number result = method(new Object()); //error
    //Integer result = method(new Integer(2)); //error
    List<? super Number> list = new ArrayList<Object>();

}

class Super {
    Number method(Number n) { return null ;}
}

class Sub extends Super {
    @Override
    Integer method(Number n) { return null ;}
}