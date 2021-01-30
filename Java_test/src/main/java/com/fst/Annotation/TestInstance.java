package com.fst.Annotation;

public class TestInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class userClass = User.class;
        User user = (User) userClass.newInstance();
        System.out.println(user);
        user.setId(123);
        user.setName("fst");
        System.out.println(user.getId());
//        instanceof 严格来说是Java中的一个双目运算符，
//        用来测试一个对象是否为一个类的实例，用法为：
//        boolean result = obj instanceof Class
//　　    其中 obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，
//        或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
    }
}
