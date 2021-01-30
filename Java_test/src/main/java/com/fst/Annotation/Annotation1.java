package com.fst.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@AC//ElementType.TYPE
public class Annotation1 {


    @AC(name="xs")//ElementType.METHOD
    public void m(){
    }

    @X("asa")
    public void mm(){

    }
}
@Retention(value = RetentionPolicy.RUNTIME)//表示运行时有效，，class表示编译后有效，source表示只有源码的时候有效，用于限制注解的有效范围
@Target(value= {ElementType.METHOD,ElementType.TYPE})//表示这个注解只能用在方法上
@interface AC{
    //定义一个注解参数，类型名+参数名();
    String name() default "";//不写默认值这个属性必须有，有默认值后可以不写


}
@interface X{
    String value() default "aa";
}