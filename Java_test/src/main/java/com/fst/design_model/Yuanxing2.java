package com.fst.design_model;

import java.io.Serializable;

public class Yuanxing2 {
    //private static Sheep2 sheep1;


    public static void main(String[] args) {

        Sheep2 sheep1 = new Sheep2();
//
//        Sheep2 sheep3 = (Sheep2) sheep1.clone();
//        Sheep2 sheep4 = (Sheep2) sheep1.clone();

        sheep1.setName("name");
        sheep1.setAge("123");
        sheep1.setColor("red");
        sheep1.sheep = new Sheep();
        System.out.println(sheep1.toString());
        sheep1.setColor("black");
        Sheep2 sheep2 = (Sheep2) sheep1.clone();
        System.out.println(sheep2.toString());
    }
}
class Sheep2 implements Cloneable, Serializable {
    String name;
    String age;
    String color;
    //在克隆时如果是浅拷贝则克隆后的sheep会指向同一个地址不不会也创建一个sheep对象
    public Sheep sheep;
    //如果是深拷贝。要对sheep也创建出新对象
    //深拷贝第一种实现实现Serializable
    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    //克隆该实例，使用默认的clone方法
    protected Object clone(){
        Sheep2 sheep = null;
        try{
            sheep = (Sheep2) super.clone();
        }catch(Exception e){
            //
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}