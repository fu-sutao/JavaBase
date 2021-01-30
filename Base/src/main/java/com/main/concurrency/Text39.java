package com.main.concurrency;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 
 * @date 2019年5月26日 上午9:40:53 @author fst @Email 820913504@qq.com
 * @purpose：ForkJoinpool线程池6种1.8新加的
 * 特点：如果一个任务比较大会被拆分成多个小任务。如果拆分后还是较大那么会继续拆分。直到合适大小。
 *线程池大多数都是ThreadPoolExecutor，如果想自定义需要new此类自己做
 */
public class Text39 {
	static int[] nums = new int[1000000];
	static final int MAX_NUM = 50000;
	static Random r = new Random();
	
	static {
		for(int i=0;i<nums.length;i++) {
			nums[i] = r.nextInt(100);
		}
		System.out.println(Arrays.stream(nums).sum());
		
	}
	static class AddTask extends RecursiveAction{
		int start , end;
		AddTask(int s,int e){
			start = s;
			end = e;
		}
		@Override
		protected void compute() {
			// 
			if(end-start <= MAX_NUM) {
				long sum = 0L;
				for(int i=start;i<end;i++)sum += nums[i];
				System.out.println("from:"+start+"to"+end+"="+sum);
			}else {
				int middle = start + (end-start)/2;
				AddTask subTask1 = new AddTask(start, middle);
				AddTask subTask2 = new AddTask(middle,start);
				subTask1.fork();
				subTask2.fork();
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// 
		ForkJoinPool fjp = new ForkJoinPool();
		AddTask task = new  AddTask(0, nums.length);
		fjp.execute(task);
		//long result = task.join();
		//System.out.println(result);
		
		System.in.read();
	}

}
























