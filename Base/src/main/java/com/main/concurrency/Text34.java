package com.main.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @date 2019年5月25日 下午8:39:38 @author fst @Email 820913504@qq.com
 * @purpose：线程池的概念
 * 固定容量的线程池
 *
 */
public class Text34 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 做1~20万之间的质数
		long start = System.currentTimeMillis();
		List<Integer> results = MyTask.getPrime(1,200000);
		long end =System.currentTimeMillis();
		System.out.println("不采用多线程计算时间"+(end-start));
		
		final int cpuCordeNum = 4;//大于等于cpu核数
		ExecutorService service = Executors.newFixedThreadPool(cpuCordeNum);
		
		MyTask t1 = new MyTask(1,80000);
		MyTask t2 = new MyTask(80001,130000);
		MyTask t3 = new MyTask(130001,170000);
		MyTask t4 = new MyTask(170001,200000);
		
		Future<List<Integer>> f1 = service.submit(t1);
		Future<List<Integer>> f2 = service.submit(t1);
		Future<List<Integer>> f3 = service.submit(t1);
		Future<List<Integer>> f4 = service.submit(t1);
		
		start = System.currentTimeMillis();
		f1.get();
		f2.get();
		f3.get();
		f4.get();
		
		end = System.currentTimeMillis();
		
		System.out.println("采用多线程计算时间"+(end-start));
		
		
		
	}
	static class MyTask implements Callable<List<Integer>>{
		int startPos,endPos;
		
		public MyTask(int s,int e) {
			// TODO 自动生成的构造函数存根
			this.startPos = s;
			this.endPos = e;
		}
		
		@Override
		public List<Integer> call() throws Exception {
			// 
			List<Integer> r = getPrime(startPos,endPos);
			return r;
		}
		static boolean isPrime(int num) {
			for(int i=2;i<num/2;i++) {
				if(num%i == 0) {
					return false;
				}
			}
			return true;
		}

		static List<Integer> getPrime(int start, int end) {
			// 
			List<Integer>resuls = new ArrayList<>();
			for(int i=start;i<=end;i++) {
				if(isPrime(i) )resuls.add(i);
			}
			return resuls;
		}
		
	}

}
























