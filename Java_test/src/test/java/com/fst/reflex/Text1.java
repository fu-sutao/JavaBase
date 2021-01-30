package com.fanshe;

import java.lang.reflect.Constructor;

/**
 * 反射的基本使用
 * @2019-5-18
 * @author Administrator
 *一切皆对象
 *反射就是对一个类的解刨，就是可以拿到你想要的东西
 *class：java里面的一个类  当定义一个类时他的类型为class（字节码类型）
 *有时候会称为类类型。
 */
public class Text1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//如何获取类类型？三种方式
		//1`类名.class
		Class c1 = Cat.class;//需要先引包，耦合
		//2`对象.getClass();
		Cat c = new Cat();
		Class c2 = c.getClass();//对象都有了也就不需要反射了
		//3`Class.forName(类的全限定名);
		Class c3;
		try {
			c3 = Class.forName("com.fanshe.Cat");//推荐使用
			//调入内存并获得一个引用
			System.out.println(c1==c2);//true
			System.out.println(c2==c3);	//true
			//创建一个后便不会再创建了
				//获取构造函数
				//获取一堆
				//获取一堆公有的构造函数
				System.out.println("----------获取公有权限的构造函数-------------");
				Constructor[] cs = c3.getConstructors();
				for(Constructor b:cs) {
					System.out.println(b);
				}
				System.out.println("----------获取所有的权限构造函数-------------");
				cs = c3.getDeclaredConstructors();
				for(Constructor b:cs) {
					System.out.println(b);
				}
				//获取单个
				//获取单个的公有的构造函数
				System.out.println("----------获取单个任意权限构造函数-------------");
				Constructor cs2 = c3.getConstructor(null);
				System.out.println(cs2);
				cs2 = c3.getDeclaredConstructor(int.class);
				System.out.println(cs2);
				//如何调用私有的构造函数
				//把去权限去掉（暴力访问）
				cs2.setAccessible(true);
				//实例化
				cs2.newInstance(3);//new Cat(3)
				
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}

class Cat{
	/**
	 * 构造函数
	 * 成员变量
	 * 成员属性
	 */
	public Cat() {
		System.out.println("公有的构造函数");
	}
	private Cat(int a) {
		System.out.println("私有的构造函数");
	}
	Cat(String b){
		System.out.println("默认的构造函数");
	}
	protected Cat(int a,String b) {
		System.out.println("保护的构造函数");
	}
}























