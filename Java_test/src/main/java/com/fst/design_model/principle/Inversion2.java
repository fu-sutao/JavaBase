package com.fst.design_model.principle;

public class Inversion2 {
    public static void main(String[] args) {
        Person2 persion = new Person2();
        persion.receive(new WeiXin());
        persion.receive(new Email2());

    }

}
//定义一个接口
interface IReceive{
    public String getInfo();
}
class Email2 implements IReceive{
    public String getInfo(){
        return "电子邮件";
    }
}
//扩展功能
class WeiXin implements IReceive{

    @Override
    public String getInfo() {
        return "weixnxin";
    }
}
//完成Persion接收消息的功能
//方法2

class Person2{
    public void receive(IReceive receive){
        //System.out.println(receive.getInfo());
    }
}
