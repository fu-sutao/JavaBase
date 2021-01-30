package com.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月20日 下午2:58:13 @author fst @Email 820913504@qq.com
 * @purpose：volatile 关键字，使一个变量在多个线程之间可见
 * AB线程都用到一个变量，java默认是A线程中保留一份copy这样如果B线程改变了该变量则线程A未必知道
 * 使用volatile关键字会让所有线程都读到变量的修改值
 * 
 * 在下面代码中running是存在于内存堆中t对象中
 * 当线程t1开始运行的时候，会吧running值从内存读到t1线程工作区，在运行过程中直接使用这个copy并不会每次都去读堆内存，这样当主线程
 * 修改running的值后t1线程感知不到，所以不会停止运行
 * 使用是volatile将会强制所有线程都去堆内存读取running的值
 * 
 * 可以阅读这篇文章深入理解
 * http://www/cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * 
 * volatile并不能保证多个线程共同修改running变量时所带来的的不一致问题，也就是说volatile不能代替synchronized
 * volatile只保证可见性不报证原子性
 * synchronized既保持可见性又保持原子性
 *
 *jmm模型
 */
public class Text11 {
	/*volatile*/ boolean running = true;//加上volatile之后表示这个值一旦改变则该线程会去主内存从新读取一下
	//不是让cpu每次去主内存中去读
	void m() {
		System.out.println("m start");
		while(running) {
			/*
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			因为有空闲所以CPU有可能会去主内存刷一下，有一定的概率逃出死循环
			*/
		}
		System.out.println("m end!");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Text11 t = new Text11();
		new Thread(t::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		t.running = false;
	}

}





























