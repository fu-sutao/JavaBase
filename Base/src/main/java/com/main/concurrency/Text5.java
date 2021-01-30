package com.main.concurrency;

public class Text5 implements Runnable{
	private int count1 = 10;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Text5 t = new Text5();
		//栈里面的一个小t指向堆内存里面的一个Text5
		for(int i=0;i<5;i++) {
			new Thread(t,"THREAD"+i).start();
		}
	}
	@Override
	public /*synchronized*/ void run() {
		// TODO 自动生成的方法存根
		//打印出来会与重复值
		count1--;
		System.out.println(Thread.currentThread().getName()+"count="+count1);
	}

}
