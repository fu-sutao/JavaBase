package com.main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @date 2019年5月26日 上午8:54:19 @author fst @Email 820913504@qq.com
 * @purpose：线程池3
 * 用途：保证任务先后执行的
 *
 */
public class Text36 {

	public static void main(String[] args) {
		// 
		ExecutorService service = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++) {
			final int j = i;
			service.execute(()->{
				
				System.out.println(j+""+Thread.currentThread().getName());
			});
		}
	}

}
























