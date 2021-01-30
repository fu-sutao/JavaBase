package com.main.concurrency;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * @date 2019年5月20日 下午3:49:00 @author fst @Email 820913504@qq.com
 * @purpose：解决同样的问题更高效的方法，使用Atomxxx类
 * Atomxxx类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 *Atom开头的都具有原子性
 */
public class Text12 {
	/*volatile */  //int count = 0;
	AtomicInteger count = new AtomicInteger(0);
	/*synchronized*/ void m() {
		for(int i = 0; i<1000; i++) {
			count.incrementAndGet();//count++并且具有原子性  效率高
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Text12 t = new Text12();
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0;i<10;i++) {
			threads.add(new Thread(t::m,"thread-"+i));
		}
		threads.forEach((o)->o.start());
		threads.forEach((o)->{
			try {
				o.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		System.out.println(t.count);
	}

}






















