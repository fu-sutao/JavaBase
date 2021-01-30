package com.fst.mianshi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class mianshi {
    @Test
    public void intlong(){
        int a = 2;
        long b = 8;
        //a = a+b;将不能编译
        a  +=b;
        //等价于
        a =(int)(a+b);
        short c = 1;
        //c = c +1;//同理会报错，原因是因为1默认为int类型
        Number num = new Integer(1);

    }
    //逆变和协变
    //下面随便看看就行，主要还是协变
    static Number method(Number num){
        Integer a = 1;
        return a;
    }
    static Son method1(Number num) {
        Father father = new Father();
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
    @Test
    public void nibian() {
        /**
         *泛型:不变
         *数组：是协变的
         * 不变，既不能从子类转化为父类也不能从父类转化为子类
         * 协变：可以从子类转化为父类
         * 逆变："可以从父类转化为子类"
         */
        //泛型的不变证明 解开注释均报错
        //ArrayList<Father> fathers = new ArrayList<Son>();
        //ArrayList<Son> fathers = new ArrayList<Father>();
        //数组的协变证明
        Number[] numbers = new Integer[3];
        //一般情况的协变
        Father father = new Son();

//        Java中泛型是不变的，可有时需要实现逆变与协变，怎么办呢？这时，通配符?派上了用场：
//        <? extends>实现了泛型的协变，比如：
        List<? extends Number> list = new ArrayList<Integer>();
//        <? super>实现了泛型的逆变，比如：
        //<? super Number>表示list所持有的类型为在Number与Number的基类中的某一类型，
        // 其中Integer与Float必定为这某一类型的子类；所以add方法能被正确调用。
        // 从上面的例子可以看出，extends确定了泛型的上界，而super确定了泛型的下界。

        //分析总结： 下面这句看似是父对象转换成了子对象，但实际上Arraylist原本上是不变，
        //第二<? super Number>使得在放入容器时只能放入Number或者他的子类，
        //而取出时默认为Number类型，也即调用方法和类变量时的范围是在Number以内所以本质上还是类似与协变
        List<? super Number> list1 = new ArrayList<Object>();
        list1.add(new Integer(1));
        list1.add(new Float(1.2f));
        long b =1;
        int a = (int)b;
//
        Son son = new Son();
        Father father1 = new Father();
        MinSon minSon = new MinSon();
        List<? super MinSon>list3 = new ArrayList<Father>();
        list3.add(minSon);
        Object[] objects = new Object[10];
        objects[1] = son;

    }
}
