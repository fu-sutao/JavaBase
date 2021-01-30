package com.fst.design_model.template;

/**
 * 模板模式把公用部分提取到抽象方法中，当做模板，
 * 有子类继承并完善
 */
public class Client {

    public static void main(String[] args) {
        //制作Redbean
        SoyMilk soyMilk = new RedBean();
        //制作Peanut
        SoyMilk soyMilk2 = new Peanut();

    }

}
abstract class SoyMilk{
    final void make(){
        select();
        if(customer()){
            addCondiments();
        }
        soak();
        beart();
    }
    void select(){
        System.out.println("1");
    }
    abstract void addCondiments();

    void soak(){
        System.out.println("3");
    }
    void beart(){
        System.out.println("4");
    }
    //钩子方法
    boolean customer(){
        return true;
    }
}
class RedBean extends SoyMilk{

    @Override
    void addCondiments() {
        System.out.println("添加");
    }
}

class Peanut extends SoyMilk{

    @Override
    void addCondiments() {
        System.out.println("jiaru");
    }
}

















