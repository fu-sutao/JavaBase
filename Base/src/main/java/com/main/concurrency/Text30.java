package com.main.concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @date 2019年5月25日 下午2:18:34 @author fst @Email 820913504@qq.com
 * @purpose：Queue队列
 * 
 * courrentLinkingQueue
 * 
 *
 */
public class Text30 {
	public static void main(String []args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();
		
		for(int i=0;i<10;i++) {
			strs.offer("a"+i);  //add
			//添加成功返回true
			//添加失败返回false
			//
		}
		
		System.out.println(strs);
		System.out.println(strs.size());
		System.out.println(strs.poll());//拿出来并删掉
		System.out.println(strs.size());
		System.out.println(strs.peek());//只拿出来不删
		System.out.println(strs.size());
	}
}
























