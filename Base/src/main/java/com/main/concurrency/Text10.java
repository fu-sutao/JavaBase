package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019年5月20日 下午2:27:37 @author fst @Email 820913504@qq.com
 * @purpose：在程序执行过程如果出现异常默认锁会被释放
 * 所以在处理并发过程中有异常要多加小心，不然可能会发生不一致的情况
 * 比如在一个webapp处理过程中，多个servlet线程共同访问一个资源，这时如果异常处理不合适在第一个线程中抛出异常，其他线程
 * 就会进入同步代码区，有可能访问到异常产生时的数据。
 * 因此要非常小心处理同步业务逻辑中的异常
 */
public class Text10 {
	int count = 0;
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+"start");
		while(true) {
			count ++;
			System.out.println(Thread.currentThread().getName()+"count"+count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(count == 5) {
				int i = 1/0;//此处抛出异常锁将被释放，要不想被释放可以进行catch让后让循环继续
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Text10 t = new Text10();
		Runnable r = new Runnable() {
			public void run() {
				t.m();
			}
		};
		new Thread(r,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Thread(r,"t2").start();
	}

}




























