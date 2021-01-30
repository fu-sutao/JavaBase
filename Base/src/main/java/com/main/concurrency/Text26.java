package com.main.concurrency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @date 2019年5月25日 上午8:54:28 @author fst @Email 820913504@qq.com
 * @purpose：线程安全的单例模式
 * https://www.cnblogs.com/xudong-bupt/p/3433643.html
 * 更好的是采用下面的方式，既不用加锁，也能实现懒加载
 * 
 * 单例
 */
public class Text26 {
	private Text26() {
		System.out.println("single");
	}
	//内部类
	private static class Inner{
		private static Text26 s = new Text26();
	}
	
	private static Text26 getSingle() {
		return Inner.s;
		
	}
	public static void main(String[] args) {
		// 
		Thread[] ths = new Thread[200];
		for(int i=0;i<ths.length;i++) {
			ths[i] = new Thread(()->{
				Text26.getSingle();
			});
			Arrays.asList(ths).forEach(o->o.start());
		}
	}

}
























