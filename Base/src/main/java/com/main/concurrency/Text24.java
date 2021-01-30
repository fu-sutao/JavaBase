package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月23日 上午8:59:34 @author fst @Email 820913504@qq.com
 * @purpose：ThreadLocal线程局部变量
 *
 */
public class Text24 {
	volatile static Person p = new Person();
	public static void main(String[] args) {
		// 
		new Thread(()->{
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				System.out.println(p.name);
			}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			p.name = "lisi";
		}).start();
	}
}
class Person{
	String name = "fst";
}
























