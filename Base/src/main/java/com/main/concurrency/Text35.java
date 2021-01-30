package com.main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月26日 上午8:32:33 @author fst @Email 820913504@qq.com
 * @purpose：缓存时线程池
 * 生存周期默认60秒
 *  
 *
 */
public class Text35 {

	public static void main(String[] args) throws InterruptedException {
		// 
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		
		for(int i=0;i<2;i++) {
			service.execute(()->{
				try {
					/*
					 	给定粒度的时间
						单位为毫秒
					 	DAYS 
						时间单位代表二十四小时  
						HOURS 
						时间单位代表六十分钟  
						MICROSECONDS 
						时间单位代表千分之一毫秒  
						MILLISECONDS 
						时间单位为千分之一秒  
						MINUTES 
						时间单位代表60秒  
						NANOSECONDS 
						时间单位代表千分之一千分之一  
						SECONDS 
						时间单位代表一秒  
					 	*/
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName());
			});	
		}
		System.out.println(service);
		TimeUnit.SECONDS.sleep(80);
		System.out.println(service);
	}

}
























