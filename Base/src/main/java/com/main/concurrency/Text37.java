package com.main.concurrency;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年5月26日 上午9:01:25 @author fst @Email 820913504@qq.com
 * @purpose：第四种
 * 定时线程池
 *
 */
public class Text37 {

	public static void main(String[] args) {
		// 
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		//固定的频率执行某个任务
		service.scheduleAtFixedRate(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName());
			
		},0,500,TimeUnit.MILLISECONDS);
		
	}

}
























