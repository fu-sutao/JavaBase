package com.main.concurrency;
//对业务写方法加锁
//对业务读方法不加锁
//产生脏读问题
/**
 * 脏读：在写操作还没执行完，就开始读取，于是读到的数据不是最新的数据属于脏读
 *
 */

import java.util.concurrent.TimeUnit;

public class DirtyRead {
	String name;
	double balance;


	public synchronized void set(String name,double balance) {
		this.name = name; //设定名字和金额
		//main 新建一个线程去设置这两个参数  并让这个线程阻塞两秒
		try{ TimeUnit.MILLISECONDS.sleep(2000);}catch(Exception e){ e.printStackTrace(); }
		this.balance = balance;
	}
	//获取余额
	public double getBalance(String name) {
		return this.balance;
	}
	
	public static void main(String[] args) {
		DirtyRead a = new DirtyRead();
		new Thread(()->a.set("fst", 100.8)).start();
//		主线程等待1秒就去读取  取的的数据不是最新的
		try{ TimeUnit.MILLISECONDS.sleep(1000);}catch(Exception e){ e.printStackTrace(); }
//		读取数据   为0
		System.out.println(a.getBalance("fst"));
		//主线程又阻塞两秒
		try{ TimeUnit.MILLISECONDS.sleep(2000);}catch(Exception e){ e.printStackTrace(); }
		//子线程已经将数据更新完毕
		System.out.println(a.getBalance("fst"));  //此时可以拿到100
	}
}























