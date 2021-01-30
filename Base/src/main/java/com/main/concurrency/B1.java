package com.main.concurrency;
/**
 * 
 */
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//ByteBuffer b = ByteBuffer.allocateDirect(10*1024*1024);
		B b = new B();
		new Thread(()->{
//			新建一个线程A，调用上锁的方法m1
			b.m1();
			
		},"A").start();
		
		new Thread(()->{
			
			b.m1();
			
		},"B").start();	
	}
}
class B{
	//创建一个锁lock  需要自己上锁自己释放锁
	Lock lock = new ReentrantLock();
	public int b = 0;
	
//	synchronized效果上等价于lock.lock();   lock.unlock();
	synchronized public void  m1() {
		lock.lock();
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"	b=	"+b);
			b++;
		}
		lock.unlock();
		
	}
	
}

