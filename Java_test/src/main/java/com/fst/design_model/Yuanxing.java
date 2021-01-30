package com.fst.design_model;

/**
 * 原型模式
 * 需求，创建同一个对象需要多个
 * 不用设计模式则直接创建
 * 确定较多
 */
public class Yuanxing {
    Sheep sheep1 = new Sheep();
    Sheep sheep2 = new Sheep();
    Sheep sheep3 = new Sheep();
    Sheep sheep4 = new Sheep();
    Sheep sheep5 = new Sheep();
    Sheep sheep6 = new Sheep();
    Sheep sheep7 = new Sheep();
    Sheep sheep8 = new Sheep();

}
class Sheep{
    String name;

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

    String age;
    String color;

}