package com.main.concurrency;

import java.util.concurrent.Executor;

/***
 * 
 * @date 2019年5月25日 下午3:09:28 @author fst @Email 820913504@qq.com
 * @purpose：第四讲：线程chi
 * 认识Executor
 * 
 * 认识Executor阅读ExecutorService  API文档
 * 
 * Callable和Runnable差不多只不过多了一个返回值
 * 
 * Executors
 *
 */
public class Text31 implements Executor{

	public static void main(String[] args) {
		// 
		new Text31().execute(()->System.out.println("hello Executer"));
	}

	@Override
	public void execute(Runnable command) {
		// 
		command.run();
	}

}
























