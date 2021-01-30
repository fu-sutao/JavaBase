package com.fst.design_model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class Client2 {
    public static void main(String[] args) {
        ITeacherDao2 target = new TeacherDao2();
        ITeacherDao2 proxyInstance = (ITeacherDao2)new ProxyFactory(target).getProxyInstance();
        //
        System.out.println(proxyInstance.getClass());
        proxyInstance.teach();
    }
}
interface ITeacherDao2{
    void teach();
}

class TeacherDao2 implements ITeacherDao2{
    //
    @Override
    public void teach() {
        System.out.println("asas");
    }
}
class ProxyFactory{
    //维护一个目标对象，Object
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
//    给目标对象生成一个代理对象
    public Object getProxyInstance(){
        //说明
        //1.loader：指定当前目标对象使用的类加载器，获取加载器的方法固定
        //2.Class<>[] interfaces:目标对象实现的接口类型，使用泛型方法确认类型
        //InvocatHandler h：事情处理，执行目标对象的方法时会触发事情处理器的方法，会把当前执行的目标对象方法作为
        //参数传入
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("jdk代理开始");

                Object returnval = method.invoke(target,args);
                System.out.println("jdk代理结束");
                return returnval;
            }
        });

    }
}























