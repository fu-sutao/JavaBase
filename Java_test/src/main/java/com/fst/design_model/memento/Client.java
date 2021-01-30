package com.fst.design_model.memento;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretake caretake = new Caretake();
        originator.setState("123");
//      在备忘录管理器中添加一个备忘录
        caretake.add(originator.saveStateMemento());
//      起始状态改变
        originator.setState("456");
//      再次保存状态
        caretake.add(originator.saveStateMemento());

        System.out.println(originator.getState());
        originator.getStateFromMemento(caretake.get(1));


    }
}
//起始类
class Originator{
    private String state;//状态信息
    //对外提供获取状态的接口
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    //编写一个方法可以保存一个状态对象Memento
    public Memento saveStateMemento(){
        return new Memento(state);
    }
    //通过备忘录对象恢复状态
    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}


//备忘录类？？？？？中间层
class Memento{

    private String state;
    //通过构造函数把状态传进来
    public Memento(String state) {
        this.state = state;
    }
    //获取状态
    public String getState() {
        return state;
    }
}
//管理备忘录的类
class Caretake{
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento){
        mementoList.add(memento);
    }
    //获取到
    public Memento get(int index){
        return mementoList.get(index);
    }

}

























