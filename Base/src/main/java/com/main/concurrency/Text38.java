package com.main.concurrency;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月26日 上午9:21:47 @author fst @Email 820913504@qq.com
 * @purpose：第五种任务窃取线程池
 * 每个线程有一个任务队列，当自己的任务执行完时会从其他线程的任务队列中调取任务执行
 */
public class Text38 {

	public static void main(String[] args) throws IOException {
		// 
		ExecutorService service = Executors.newWorkStealingPool();
		//打印CPU核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		service.execute(new R(1000));
		service.execute(new R(2000));
		service.execute(new R(2000));//daemon线程
		service.execute(new R(2000));
		service.execute(new R(2000));
		
		//由于产生的是精灵线程（守护线程，后台线程）主线程不阻塞的话看不到输出
		System.in.read();
	}
	static class R implements Runnable{
		int time;
		R(int t){
			this.time = t;
		}
		@Override
		public void run() {
			// 
			try {
				TimeUnit.MILLISECONDS.sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(time+""+Thread.currentThread().getName());
		}
		
	}

}























