package com.fst.designmodel;
public class Dan_li {
private volatile static Dan_li singleton; //当前实例静态化
    //volatile禁止reorder
    //当变量被修改其他线程重新去主内存中获取数据
    private Dan_li() {
        System.out.println("构造函数被执行");

    }  //构造器私有化不让重写
    public static Dan_li getSingleton() {
        if (singleton == null) {
            synchronized (Dan_li.class) {
                if (singleton == null) {
                    singleton = new Dan_li();
                    //上面这句话有两个执行顺序方案
                    //先分配内存         正常顺序
                    //执行构造器
                    //将内存地址复制给singleton    这个操作执行后不再为空

                    //5.0之前的版本  执行顺序可能重排为
                    //先分配内存
                    //将内存地址复制给singleton
                    //执行构造器
                }
            }
        }
        return singleton;
    }
}







































