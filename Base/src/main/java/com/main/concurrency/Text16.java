package com.main.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月21日 下午2:26:03 @author fst @Email 820913504@qq.com
 * @purpose：曾经的面试题（淘宝）
 * 实现一个容器。提供两个方法 add size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时线程2提示并结束
 *
 */
public class Text16 {
	volatile List lists = new ArrayList();
	
	public void add(Object o) {
		lists.add(o);
	}
	public int size() {
		return lists.size();
	}
	public static void main(String[] args) {
		// 
		Text16 t = new Text16();
		new Thread(()->{
			for(int i=0;i<10;i++) {
				t.add(new Object());
				System.out.println("add"+i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}, "t1").start();
		new Thread(()->{
			while(true) {
				if(t.size() == 5) {
					break;
				}
			}
			System.out.println("t2结束");
		},"t2").start();
	}

}
























