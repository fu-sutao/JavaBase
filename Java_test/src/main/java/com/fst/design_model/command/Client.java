package com.fst.design_model.command;

public class Client {
    public static void main(String[] args) {
        //使用用户命令模式，完成通过遥控器，对点灯的操作
        LightReceiver lightReceiver = new LightReceiver();
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);

        RemooteController remooteController = new RemooteController();
        remooteController.setCommands(0,lightOnCommand,lightOffCommand);
        remooteController.onButtonWasPushed(0);
    }
}
//创建命令接口
interface Command{
    //执行动作（操作）
    public void execute();
    //撤销动作
    public void undo();
}
class LightOnCommand implements Command{
    //聚合receiver
    LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用lightreceiver的方法
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}
class LightReceiver{
    public void on(){
        System.out.println("电灯打开");
    }
    public void off(){
        System.out.println("电灯关闭了");
    }
}
class LightOffCommand implements Command{
    //聚合receiver
    LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用lightreceiver的方法
        lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}
//没有任何命令 即空执行。用于初始化每个按钮，当调用空命令时，对象什么都不做
class NoCommand implements Command{

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
class RemooteController{
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommands;

    public RemooteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for(int i = 0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }
    //给我们的按钮设置命令
    public void setCommands(int no, Command onCommand, Command offComand){
        onCommands[no] = onCommand;
        offCommands[no] = offComand;
    }
    //按下开按钮
    public void onButtonWasPushed(int no){
        //找到你按下的按钮，并调用对应的方法
        onCommands[no].execute();
        //记录这次的操作
        undoCommands = onCommands[no];
    }
    //按下开按钮
    public void offButtonWasPushed(int no){
        //找到你按下的按钮，并调用对应的方法
        offCommands[no].execute();
        //记录这次的操作
        undoCommands = onCommands[no];
    }
    public void undoButton(){
        undoCommands.undo();
    }

}



















