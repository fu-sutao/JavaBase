package com.fst.design_model.state;

import java.util.Random;

public class Client {


}
//状态接口
interface state{
    //扣除积分
    void deduceMony();
    //发放奖品
    void dispensePrize();
    //是否抽中奖品
    boolean raffle();
}
//不能抽奖状态
class NoRaffleState implements state{
    Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }
    //当前状态可以扣积分，扣除后，把状态设置成可以抽奖状态
    @Override
    public void deduceMony() {
        System.out.println("扣除积分成功可以抽奖");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }

    @Override
    public boolean raffle() {
        System.out.println("扣除积分才能抽奖");
        return false;
    }
}
//能抽奖的状态
class CanRaffleState implements state{
    Activity activity;

    public CanRaffleState(Activity activity) {
        this.activity = activity;
    }
    //当前状态可以扣积分，扣除后，把状态设置成可以抽奖状态
    @Override
    public void deduceMony() {
        System.out.println("已经扣过积分");

    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖");
        Random r = new Random();
        int num = r.nextInt(10);
        if(num ==0){
            activity.setState(activity.getDispensePrize());
        }else {
            activity.setState(activity.getNoRaffleState());
        }
        return false;
    }

}
class DispensePrize implements state{

    @Override
    public void deduceMony() {

    }

    @Override
    public void dispensePrize() {

    }

    @Override
    public boolean raffle() {
        return false;
    }
}

class DispenseOutPrize{

}
class Activity{
    //state表示当前状态，是变化的
    state state = null;
    int count = 0;
    //四种状态
    CanRaffleState canRaffleState;
    DispensePrize dispensePrize;
    NoRaffleState noRaffleState;

    public Activity(int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    public NoRaffleState getNoRaffleState() {
        return noRaffleState;
    }

    public DispensePrize getDispensePrize() {
        return dispensePrize;
    }

    public CanRaffleState getCanRaffleState() {
        return canRaffleState;
    }

    void setState(state s) {
        this.state = s;
    }
}