package com.main.concurrency;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月23日 上午7:27:56 @author fst @Email 820913504@qq.com
 * @purpose：面试题：写一个固定容量的同步器，拥有put和get方法以及getCount方法
 * 能够支持2个生产者线程以及8个消费者线程阻塞调用
 * 
 * 使用wait和notify/notifyall来实现
 *
 */
public class Text22<T> {
	final private LinkedList<T> list = new LinkedList<>();
	final private int MAX = 10;//最多十个元素
	private int count = 0;
	public synchronized void put(T t) {
		while(list.size() == MAX) { //想想为什么用while而不是用if
			try {
				this.wait();//while大多和wait一块用
				//如果用if被唤醒时一个其他的线程向里面添加一个元素下面就会报错
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		list.add(t);
		count++;
		this.notifyAll();
		//通知消费者线程进行消费
	}
	public synchronized T get() {
		T t = null;
		while(list.size() == 0) {
			try {
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		t = list.removeFirst();
		count--;
		this.notifyAll();//通知生产者进行生产
		return t;
	}
	
	public static void main(String[] args) {
		// 
		Text22<String> c = new Text22<>();
		//启动消费者线程
		for(int i=0;i<10;i++) {
			new Thread(()->{
				for(int j=0;j<5;j++) {
					System.out.println(c.get());
				}
			},"c"+i).start();
		}
		
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//启动消费者线程
		for(int i=0;i<2;i++)
		{
			new Thread(()-> {
				for(int j=0;j<25;j++) 
					c.put(Thread.currentThread().getName()+"" +j);
				
				
			},"p"+i).start();
		}

	}

}
























