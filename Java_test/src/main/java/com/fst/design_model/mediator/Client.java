package com.fst.design_model.mediator;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {

    }
}
abstract class Mediator{
    //
    public abstract void Register(String name, Alarm alarm);
    public abstract void getMessage(int stateChange,String name);
    public abstract void sendMessage();
}

//具体的中介者类
class ConcreteMediator extends Mediator{
    private HashMap<String ,Colleague> colleagueHashMap;
    private HashMap<String ,String> interMap;

    public ConcreteMediator() {
        this.colleagueHashMap = new HashMap<String ,Colleague>();
        this.interMap = new HashMap<String ,String>();
    }

    @Override
    public void Register(String name, Alarm alarm) {

    }

    @Override
    public void getMessage(int stateChange, String name) {

    }

    @Override
    public void sendMessage() {

    }
}
//同事抽象类
abstract class Colleague{
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract  void sendMessage(int stateChange);
    public Mediator getMediator(){
        return this.mediator;
    }
}
class Alarm extends Colleague{

    public Alarm(Mediator mediator,String name){
        super(mediator,name);
        mediator.Register(name,this);
    }
    @Override
    public void sendMessage(int stateChange) {
        SendMessage(stateChange);
    }
    public void SendMessage(int stateChange){
        this.getMediator().getMessage(stateChange ,this.name);
    }
}
class CoffeeMachine{

}
























