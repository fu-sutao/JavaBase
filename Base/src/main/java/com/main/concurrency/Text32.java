package com.main.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月25日 下午3:26:50 @author fst @Email 820913504@qq.com
 * @purpose：线程池的概念
 * FixedThreadPool线程池
 *
 */
public class Text32 {

	public static void main(String[] args) throws InterruptedException {
		// new一个5个线程的线程池
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<6;i++) {
			service.execute(()->{
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName());
			});
			
		}
		System.out.println(service);
		service.shutdown();//线程池的正常关闭
		//service.shutdownNow()断电式关闭。
		System.out.println(service.isTerminated());//看下所有的任务是不是都执行完了
		System.out.println(service.isShutdown());//true执行了关闭并不代表一定准确的关闭了。
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}

}
























