package com.main.concurrency;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @date 2019年5月23日 上午7:27:56 @author fst @Email 820913504@qq.com
 * @purpose：面试题：写一个固定容量的同步器，拥有put和get方法以及getCount方法
 * 能够支持2个生产者线程以及8个消费者线程阻塞调用
 * 
 * 使用wait和notify/notifyall来实现
 *
 *使用Lock和Conition来实现
 *对比两种方式，Conition的方式可以更加精确的指定哪些线程被唤醒
 */
public class Text23<T> {
	final private LinkedList<T> list = new LinkedList<>();
	final private int MAX = 10;//最多十个元素
	private int count = 0;
	
	private Lock lock1 = new ReentrantLock();
	private Condition producer = lock1.newCondition();
	private Condition consumer = lock1.newCondition();
	
	public synchronized void put(T t) {
		
			try {
				lock1.lock();
				while(list.size() == MAX) {
					producer.await();
				}
				list.add(t);
				count++;
				consumer.signalAll();//通知消费者线程进行消费
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock1.unlock();
			}
	}
	public T get() {
		T t = null;
		
			try {
				lock1.lock();
				while(list.size() == 0) {
					producer.await();
				}
				t = list.removeFirst();
				count--;
				producer.signalAll();//通知生产者进行生产
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock1.unlock();
			}
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
























