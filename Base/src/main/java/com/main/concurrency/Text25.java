package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月23日 上午9:08:21 @author fst @Email 820913504@qq.com
 * @purpose：ThreadLocal线程局部变量
 * 
 * ThreadLocal是空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中sission就存在与ThreadLocal中避免synchronized的使用
 * 
 * 运行下面的程序，理解
 *
 */
public class Text25 {
	
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	
	public static void main(String[] args) {
		// 
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(tl.get());
		}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			tl.set(new Person());
		}).start();
	}

}
























