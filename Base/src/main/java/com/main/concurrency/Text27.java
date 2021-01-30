package com.main.concurrency;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月25日 上午9:13:42 @author fst @Email 820913504@qq.com
 * @purpose：有N个火车票，每个票都有一个编号
 * 同时又十个窗口对外售票
 * 
 *
 */
public class Text27 {
	//同步的容器
	static Vector<String> tickets = new Vector<>();
	
	static {
		for(int i=0;i<1000;i++) {
			tickets.add("票编号="+i);
		}
	}
	public static void main(String[] args) {
		// 
		for(int i=0;i<10;i++) {
			new Thread(()->{
				while(tickets.size() > 0) {
				try {
					TimeUnit.MICROSECONDS.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}	
				}
				System.out.println("销售了--"+tickets.remove(0));
			}).start();
		}

	}

}
























