package com.fst.design_model.visitor;

import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());
        Sucess sucess = new Sucess();
        objectStructure.display(sucess);
    }
}
abstract class Action{
    //
    public abstract void getManResult(Man man);
    public abstract void getWomanResult(Woman woman);

}
class Fail extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男歌手给失败评价");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女歌手给失败评价");
    }
}
class Sucess extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男歌手给成功评价");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女歌手给成功评价");
    }
}
abstract class Persion{
    //提供一个方法让访问者可以访问
    public abstract void accept(Action action);
}

class Man extends Persion{

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
//这里使用到了双分派，即在客户端程序中讲具体状态参数传递Woman中
//让后Woman类调用作为具体的方法
class Woman extends Persion{
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
//数据结构管理很多人
class ObjectStructure{
    //维护一个集合
    private List<Persion> persions = new LinkedList<>();
    //增加到list
    public void attach(Persion p){
        persions.add(p);
    }
    public void detach(Persion p){
        persions.remove(p);
    }
    //显示测评情况
    public void display(Action action){
        for (Persion p:persions){
            p.accept(action);
        }
    }
}


















