package com.fst.design_model.strategy;

public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
    }


}
//策略接口
interface FlyBehavior{
    public void fly();
}
class GoodFly implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("飞翔技术高");
    }
}
class BadFly implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("飞翔技术差");
    }
}


abstract class Duck{
    //属性策略接口
    FlyBehavior flyBehavior;

    abstract void display();//显示鸭子信息
    public void quack(){
        System.out.println("鸭子叫00");
    }
    public void swim(){
        System.out.println("鸭子游泳---");
    }
    public void fly(){
        if(flyBehavior!=null){
            flyBehavior.fly();
        }
    }
}
class WildDuck extends Duck {
    //
    public WildDuck() {
        flyBehavior = new GoodFly();
    }

    @Override
    void display() {
        System.out.println("这是野鸭");
    }
}
class PekingDuck extends Duck{

    @Override
    void display() {

    }
    //因为北京鸭不能飞

}
class ToyDuck extends Duck{

    @Override
    void display() {
        System.out.println("玩具鸭");
    }
    //需要重写所有方法

    @Override
    public void quack() {
        System.out.println("玩具鸭不会叫");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不会飞");
    }
}

























