package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019年5月21日 下午1:59:38 @author fst @Email 820913504@qq.com
 * @purpose：锁定某对象O变成另外一个对象，则锁定的对象发生改变
 * 但是如果O变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象
 *
 */
public class Text14 {
	Object o = new Object();
	//锁的信息在堆内存里
	void m() {
		synchronized (o) {
			while(true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public static void main(String[] args) {
		// 
		Text14 t = new Text14();
		new Thread(t::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建第二个线程
		Thread  t2 =new Thread(t::m,"t2");
		t.o = new Object();//锁对象发生改变 所以t2线程又得以执行，如果注释掉这句话
		//线程2将永远的不到执行的机会
		t2.start();
	}

}
























