package com.fst.Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Access {


    public static void test(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i <1000000000;i++){
            user.getName();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("普通方法10亿次用时为："+(startTime-stopTime)+"ms");
    }
    public static void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c=user.getClass();
        Method method = c.getDeclaredMethod("getName",null);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i <1000000000;i++){
            method.invoke(user,null);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("反射方法10亿次用时为："+(startTime-stopTime)+"ms");
    }
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c=user.getClass();


        Method method = c.getDeclaredMethod("getName",null);
        method.setAccessible(true);//关闭检查
        long startTime = System.currentTimeMillis();
        for(int i = 0;i <1000000000;i++){
            method.invoke(user,null);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("关闭检查10亿次用时为："+(startTime-stopTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test();
        test1();
        test2();
    }
}
