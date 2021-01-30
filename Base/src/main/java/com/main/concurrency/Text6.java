package com.main.concurrency;
//在一个synchronized方法执行时非synchronized方法可以继续执行
public class Text6 {
	public synchronized void m1() {
		System.out.println(Thread.currentThread().getName()+"m1 start......");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getName()+"m1 end......");
	}
	public  void m2() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getName()+"m2 end......");
	}
	public static void main(String[] args) {
		Text6 t = new Text6();
		//new Thread(()->t.m1(),"t1").start();
		//new Thread(()->t.m2(),"t2").start();
		/**/
		//new Thread(t::m1,"t1").start();
		//new Thread(t::m2,"t2").start();
		
		//等价于
		new Thread() {
			public void run() {
				t.m1();
			}
		};
	} 
	
}




































