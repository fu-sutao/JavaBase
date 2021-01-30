package com.fst.design_model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//相当于客户端，发出订购
public class Factory {

    public static void main(String[] args) {
        //new OrderPizza();
    }


}
abstract class Pizza{
    protected String name;

    //准备原料,不同的pizza不一样。因此做成抽象方法
    public abstract void prepare();
    public  void back(){
        System.out.println("烘烤");
    }
    public  void cut(){

    }
    public  void box(){

    }
    public  void setname(String name){
        this.name = name;
    }
}

class GreekPizza extends Pizza {

    @Override
    public void prepare() {

    }
}
class CheesePizza extends Pizza{

    @Override
    public void prepare() {

    }
}

class OrderPizza{
//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType;
//        do{
//            orderType = getType();
//            if(orderType.equals("greek")){
//                pizza = new GreekPizza();
//                pizza.setname("希腊pizza");
//            }else if(orderType.equals("cheek")){
//                pizza = new CheesePizza();
//                pizza.setname("奶咯pizza");
//            }else {
//                break;
//            }
//            pizza.prepare();
//            pizza.back();
//            pizza.cut();
//            pizza.box();
//
//        }while (true);
//    }
    //写一个方法，可以获取客户订购pizza的种类
    private String getType(){
        try{

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type");
            String str = bufferedReader.readLine();
            return str;
        }catch(Exception e){
            return "";
        }
    }
    public OrderPizza(SimpFactory simpFactory){
        this.simpFactory = simpFactory;
    }

    Pizza pizza = null;
    SimpFactory simpFactory;
    public void setSimpFactory(SimpFactory simpFactory){
        String orderType = "";
        this.simpFactory = simpFactory;
        do{
            orderType = getType();
            this.simpFactory.creatPizza(orderType);
            //输出pizza
            if(pizza!=null){
                pizza.prepare();
                pizza.back();
                pizza.cut();
                pizza.box();
            }else{

            }
        }while (true);
    }
}

class SimpFactory{

    public Pizza creatPizza(String orderType){
        Pizza  pizza = null;
        System.out.println("");
        //orderType = getType();
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setname("希腊pizza");
        }else if(orderType.equals("cheek")){
            pizza = new CheesePizza();
            pizza.setname("奶咯pizza");
        }
        return pizza;
    }
    ;
}





























