package com.main.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @date 2019年5月21日 下午9:38:30 @author fst @Email 820913504@qq.com
 * @purpose：使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要手动释放锁
 * 使用synchronized锁定的话如果遇到异常，jvm会自动释放锁但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 *使用Reentrant还可以用LockInterrupt方法，可以对线程Interrupt方法做出响应
 *在一个线程等待锁的过程中可以被打断
 *
 *ReentrantLock还可以指定为公平锁
 */
public class Text20 {
	Lock lock = new ReentrantLock();
	void m1() {
		lock.lock();//手动加锁
		try {
			
			for(int i=0;i<10;i++) {
				TimeUnit.SECONDS.sleep(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();//手动释放锁
		}
	}
	void m2() {
		lock.lock();
		System.out.println("m2.....");
		lock.unlock();
	}
	/**
	 * 使用TryLock进行尝试锁定，不管锁定与否，方法都继续执行
	 * 可以根据TryLOck的返回值来确定
	 * 也可以根据tryLock的时间由于TryLOck（time）抛出异常所以要注意unclock的处理，必须放到finally中
	 */
	void m3() {
		/*
		boolean locked = lock.tryLock();
		System.out.println("m3....."+locked);
		if(locked)
		{
			lock.unlock();
		}
		*/
		
		
		boolean locked1 = false;
		try {
			locked1 = lock.tryLock(5,TimeUnit.SECONDS);
			System.out.println("m3....."+locked1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(locked1)
				lock.unlock();
		}
		
		
		
	}
	public static void main(String[] args) {
		// 
		Text20 t = new Text20();
		
		new Thread(t::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Thread(t::m2).start();
	}

}
























