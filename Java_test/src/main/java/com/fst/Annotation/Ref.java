package com.fst.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ref {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("com.fst.Annotation.User");
        Class c1 = Class.forName("com.fst.Annotation.User");

        System.out.println(c);
        //一个类在内存种只有一个class对象
        //一个类被加载后，类的整个结构会被封装在Class对象中
        System.out.println("class hashCode="+c.hashCode());
        System.out.println(c1.hashCode());
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        //获取属性
        //Field[] fields = c.getFields();//只能找到public属性
        Field[] fields = c.getDeclaredFields();//可以找到所有属性
        for(Field field:fields){
            System.out.println(field);
        }
        ///获取本类的所有方法
        Method[] methods = c.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        System.out.println("===========================真===");
        Annotation[] a = c.getAnnotations();
        for(Annotation annotation :a){
            System.out.println(annotation);
        }
        AC ac = (AC) c.getAnnotation(AC.class);
        System.out.println(ac.name());


        AC ac1 = c.getMethod("test").getAnnotation(AC.class);
        System.out.println(ac1.name());
    }
}
@AC(name = "table")
class User{
    private String name;
    private String passwd;
    private int id;
    @X
    public User(String name, String passwd, int id) {
        this.name = name;
        this.passwd = passwd;
        this.id = id;
    }
    public User() {
    }
    @AC(name = "as")
    public void test(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", id=" + id +
                '}';
    }
}