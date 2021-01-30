package com.main.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 
 * @date 2019年5月25日 上午9:55:50 @author fst @Email 820913504@qq.com
 * @purpose：写时复制容器 copy on write
 * 多线程环境下，写时效率非常低，读时效率非常高
 * 适合写少读多的环境
 *
 */
public class Text29 {

	public static void main(String[] args) {
		// 
		List<String> lists = 
				//new ArrayList<>();//会出并发问题
				//new Vector();
				new CopyOnWriteArrayList<>();
		Random r = new Random();
		Thread[] ths = new Thread[100];
		
		for(int i=0;i<ths.length;i++) {
			Runnable task = new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<1000;i++) {
						lists.add("a"+r.nextInt(10000));
					}
					
				}
			};
			ths[i] = new Thread(task);
		}
		runAndComputeTime(ths);
		System.out.println(lists.size());
		
	}

	private static void runAndComputeTime(Thread[] ths) {
		// 
		long s1 = System.currentTimeMillis();
		Arrays.asList(ths).forEach(t->t.start());
		Arrays.asList(ths).forEach(t->{
			try {
				t.join();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
	}

}
























