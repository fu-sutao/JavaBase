package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月21日 下午4:17:47 @author fst @Email 820913504@qq.com
 * @purpose：reentrantlock用于代替synchronized
 * 本利中由于m1锁定this只有m1执行完毕的时候m2才执行
 * 这里是复习synchronized最原始的语义
 *
 */
public class Text19 {
	synchronized void m1() {
		for(int i=0; i<10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(i);
		}
	}
	synchronized void m2() {
		System.out.println("m2......");
	}
	public static void main(String[] args) {
		Text19 r1 = new Text19();
		new Thread(r1::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Thread(r1::m2).start();
	}

}
























