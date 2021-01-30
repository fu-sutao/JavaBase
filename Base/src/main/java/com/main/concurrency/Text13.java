package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月21日 下午1:49:31 @author fst @Email 820913504@qq.com
 * @purpose：在synchronized优化
 * 在同步代码块中语句越少越好
 * 比较m1和m2
 *
 */
public class Text13 {
	int count = 0;
	
	synchronized void m1() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//在业务逻辑中只有下面这句需要sync这时不应给整个方法上锁
		count ++;
		try {
			TimeUnit.SECONDS.sleep(2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void m2() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//在业务逻辑中只有下面这句需要sync这时不应给整个方法上锁
		//采用细粒度的锁，可以使线程征用时间变短，从而提高效率
		synchronized (this){
		count ++;
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// 

	}

}
























