package com.main.concurrency;

/**
 *volatile并不能保证多个线程共同修改runing变量时所带来的不一致问题，也就是说volatile不能代替synchronized
 * 运行下面的程序，并分析数据
 */
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Text9 {
	volatile int count = 0;
	void m() {
		for(int i=0;i<10000;i++)count++;
	}
	public static void main(String []args) {
		Text9 t = new Text9();
		List<Thread> threads =  new ArrayList<Thread>();
		for(int i=0;i<10;i++) {
			threads.add(new Thread(t::m,"thread="+i));
		}
		threads.forEach((o)->(o).start());
		threads.forEach((o)->{
			try {
				(o).join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		System.out.println(t.count);
		
	}
}
