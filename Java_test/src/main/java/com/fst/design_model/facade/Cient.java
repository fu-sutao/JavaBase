package com.fst.design_model.facade;

/**
 * 外观模式
 */
public class Cient {
    public static void main(String[] args) {
        HomeThreaterFacade homeThreaterFacade = new HomeThreaterFacade();
        //调用高层模块
        homeThreaterFacade.ready();
    }

}
//对子模块抽象出一个高层管理统一调用管理子模块
class HomeThreaterFacade{
    //定义各个子模块的对象
    private DvDPlayer dvDPlayer;
    private Popcorn popcorn;
    private Projector projector;
    public HomeThreaterFacade(){
        //子模块初始化
        dvDPlayer = DvDPlayer.getInstance();
        popcorn = Popcorn.getInstance();
        projector= Projector.getInstance();
    }
    //对子模块统一调用
    public void ready(){
        dvDPlayer.on();
        popcorn.on();
        projector.on();
    }

}
//子模块1
class DvDPlayer{
    private static DvDPlayer Instance = new DvDPlayer();
    public static DvDPlayer getInstance(){
        return Instance;
    }
    public void on(){
        System.out.println("dvd on");
    }
    public void off(){
        System.out.println("dvd off");
    }
    public void play(){
        System.out.println("dvd is playing");
    }
}
//子模块2
class Popcorn{
    private static Popcorn Instance = new Popcorn();

    public static Popcorn getInstance() {
        return Instance;
    }
    public void on(){
        System.out.println("Pop on");
    }
    public void off(){
        System.out.println("Pop off");
    }
    public void Pop(){
        System.out.println("pop");
    }

}
//子模块3
class Projector{
    private static Projector Instance = new Projector();

    public static Projector getInstance() {
        return Instance;
    }
    public void on(){
        System.out.println("Projector on");
    }
    public void off(){
        System.out.println("Projector off");
    }
    public void Projector(){
        System.out.println("Projector");
    }
}













