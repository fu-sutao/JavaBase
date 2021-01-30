package com.fst.design_model;

/**
 * 饿汉式
 */
public class Dan1 {
    public static void main(String[] args) {
        Er er = Er.getDan1();
        Er er1 = Er.getDan1();
        System.out.println(er==er1);//true
        Enu enu = Enu.enu;
        Enu enu1 = Enu.enu;
        System.out.println(enu==enu1);
    }
}
//饿汉式1
class Er extends CheesePizza {
    //私有化构造函数
    private Er(){}
    //本类内部创建对象实例
    private final static Er er = new Er();
    //3.提供一个公有的静态方法返回实例对象
    public static Er getDan1(){
        return er;
    }
}
//饿汉式2
class Er2{
    //私有化构造函数
    private Er2(){}

    private static Er2 er2;
    static {
        //在静态代码块中创建实例对象
        er2 = new Er2();
    }

    //3.提供一个公有的静态方法返回实例对象
    public static Er2 getDan1(){
        return er2;
    }
}
//懒汉式1
class Lan{
    private static Lan lan;
    private Lan(){}
    //提供一个公有的方法使用到该方法时才创建
    public static Lan getLan(){
        if(lan ==null){
            lan = new Lan();
        }
        return lan;
    }
}
//懒汉式2
class Lan2{
    private static Lan2 lan;
    private Lan2(){}
    //提供一个公有的方法使用到该方法时才创建
    //加入线程安全问题
    public static synchronized Lan2 getLan(){
        if(lan ==null){
            lan = new Lan2();
        }
        return lan;
    }
}
//双重检查


//静态内部类
class Sta{
    //Runtime
    private static Sta sta;
    private Sta(){}
    //静态内部类不会立即加载，且加载过程线程安全
    private static class Stainit{
        private static final Sta sta1 = new Sta();
    }
    //提供一个静态公有方法，
    public static synchronized Sta getSta(){
        return Stainit.sta1;
    }
}

//枚举类型
enum Enu{
    enu;//属性
    public void sayOK(){
        System.out.println("ok");
    }
}



















