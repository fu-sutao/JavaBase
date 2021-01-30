package com.fst.design_model.principle;

/**
 * 开闭原则
 */
public class Ocp {
    public static void main(String[] args) {

    }

}
class GraphicEiitor{
    //接受Shape对象，让后根据type来绘制不同的图形
    public void drawShap(Shape s){
        if(s.m_type == 1){
            drawRectangle(s);
        }else if(s.m_type == 2){
            drawCircle(s);
        }
    }
    public void drawRectangle(Shape r){
        System.out.println("绘制矩形");
    }
    public void drawCircle(Shape r){
        System.out.println("绘制圆形");
    }
}
class Shape{
    int m_type;
}
//绘制矩形
class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}
//绘制圆形
class Circle extends Shape{
    Circle(){
        super.m_type = 2;
    }
}
//当新怎三角形时需要作出大量改进























