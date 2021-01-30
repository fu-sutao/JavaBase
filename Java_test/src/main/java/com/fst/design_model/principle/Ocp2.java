package com.fst.design_model.principle;

/**
 * 开闭原则
 */
public class Ocp2 {
    public static void main(String[] args) {

    }

}
class GraphicEiitor2{
    //接受Shape对象，让后根据type来绘制不同的图形
    public void drawShap(Shape2 s){
       s.draw();
    }

}
//基类
abstract class Shape2{
    int m_type;
    public abstract void draw();//抽象方法
}
//绘制矩形
class Rectangle2 extends Shape2{
    Rectangle2(){
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
//绘制圆形
class Circle2 extends Shape2{
    Circle2(){
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}
//此时新增一个功能变的比较容易























