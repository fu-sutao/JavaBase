package com.main.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @date 2019年5月23日 上午7:14:51 @author fst @Email 820913504@qq.com
 * @purpose：
 *
 */
public class Text21 extends Thread{
	public static ReentrantLock lock = new ReentrantLock(true);
	//true表示为公平锁，请对比输出结果  效率低
	public void run() {
		for(int i=0;i<100;i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"获得锁");
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}
		
	}
	public static void main(String[] args) {
		// 
		Text21  t = new Text21();
		Thread th1 = new Thread(t);
		Thread th2 = new Thread(t);
		th1.start();
		th2.start();
	}

}
























