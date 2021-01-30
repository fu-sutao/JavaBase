package com.fst.design_model.decorator;

/**
 * 装饰者模式
 */
public class coffeeBar {
    public static void main(String[] args) {
        //装饰者模式下订单
        Drink order = new LongBlack();
        //order = new Milk(order);
        order = new Milk(order);
    }

}
abstract class Drink{
    public String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price = 0.0f;
    //由子类去实现
    public abstract float cost();
}



class Coffee extends Drink{

    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Espresso extends Coffee{
    public Espresso(){
        setDes("意大利咖啡");
        setPrice(6.0f);
    }
}
class LongBlack extends Coffee{
    public LongBlack(){
        setDes("longblack");
        setPrice(5.0f);
    }
}
class Shortblack extends Coffee{
    public Shortblack(){
        setDes("Shortblack");
        setPrice(3.0f);
    }
}
class Decorator extends Drink{
    private Drink o;
    @Override
    public float cost() {
        //拿到自己的价格+drink价格
        return super.getPrice()+o.cost();
    }
    public Decorator(Drink a){
        this.o=a;
    }

    @Override
    public String getDes() {
        //输出了被装饰者信息
        return super.des+super.getPrice()+o.getDes();
    }
}
//具体的Decorator
class Chocolate extends Decorator{
    public Chocolate(Drink obj){
       super(obj) ;
       setDes("巧克力");
       setPrice(4.5f);//调味品的价格
    }

}
class Milk extends Decorator{
    public Milk(Drink obj){
        super(obj) ;
        setDes("牛奶");
        setPrice(4.0f);//调味品的价格
    }
}
class Soy extends Decorator{
    public Soy(Drink obj){
        super(obj) ;
        setDes("豆浆");
        setPrice(1.0f);//调味品的价格
    }
}







