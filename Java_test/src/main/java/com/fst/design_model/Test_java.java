package com.fst.design_model;

/**
 * 让一个类只能实例化一次
 */
public class Test_java {
    private Test_java(){
//构造函数私有化。
    }
    public Test_java getTest_java(){
        Test_java test_java = null;
        if(test_java == null){
            test_java = new Test_java();
        }
        return test_java;
    }
}
