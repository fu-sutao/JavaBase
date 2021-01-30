package com.fst.design_model.principle;

/**
 * 依赖倒置
 */
public class Inversion {
    public static void main(String[] args) {
        Person persion = new Person();
        Email email = new Email();
        persion.recive(email);

    }

}
class Email{
    public String getInfo(){
        return "电子邮件";
    }
}
//完成Persion接收消息的功能
//方法1
//1·简单，比较容易想到
//2·如果我们获取的对象是微信，则需要新增类同时Persion也要增加相应的方法
//3·解决思路：引入一个抽象类的接口IReceive表示接收者，这样person类与接口Ireceive发生依赖
//  因为Email weixin等等属于接收范围他们各自实现Ireceive接口就行这样就符合依赖倒置原则
class Person{
    public void recive(Email email){
        System.out.println(email.getInfo());
    }
}























