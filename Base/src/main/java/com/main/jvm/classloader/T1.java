package com.main.jvm.classloader;
public class T1 {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T{
    public static T t = new T();//1
    public static int count = 2;//2
    //12顺序不一样count也不一样
    private T(){
        count++;
        System.out.println("count++");
    }
}