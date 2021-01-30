package com.main.concurrency;
import java.util.concurrent.TimeUnit;
/*
 * 一个同步方法调用另一个同步方法，一个线程已经拥有了某个对象的锁，再次申请的时候任然会得到该对象的锁，
 * 也就是说synchronized获得的锁是可重入的
 * 方法m1被锁锁住，默认用this对象上锁，此时程序计数器是上+1，第一个方法调用第二个方法，第二个方法也被锁锁住，程序计数器再加1，
 * m2执行完后，释放一个锁，程序计数器减1，执行完m1后程序计数器再减一，此时锁完全不释放
 *
 *
 * */
public class Text8 {
	synchronized void m1() {
		System.out.println("m1   start.....");
		try{ TimeUnit.MILLISECONDS.sleep(1000);}catch(Exception e){ e.printStackTrace(); }
		m2();
	}
	synchronized void m2() {
		System.out.println();
		try{ TimeUnit.MILLISECONDS.sleep(2000);}catch(Exception e){ e.printStackTrace(); }
		System.out.println("m2");
	}
}
