package com.main.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @date 2019年5月21日 下午3:50:34 @author fst @Email 820913504@qq.com
 * @purpose：使用Latch（门闩 ）代替wait notify来进行通知
 *好处是通信方式简单，同时也可以指定等待时间
 *使用await和countdown代替wait和notify
 *CountDownLatch不涉及锁定，当count的值为零时，当前线程继续运行
 *当不涉及同步只涉及线程通讯的时候，用synchronized wait notify就显得太重了
 *这时应该考虑countdownlathe/cyclicbarrier/semaphore
 *
 */
public class Text18 {
volatile List lists = new ArrayList();
	
	public void add(Object o) {
		lists.add(o);
	}
	public int size() {
		return lists.size();
	}
	public static void main(String[] args) {
		// 
		Text18 t =new Text18();
		CountDownLatch latch = new CountDownLatch(1);
		new Thread(()->{
			if(t.size() != 5) {
				try {
					latch.await();//由于门闩的作用线程在此暂停
					//也可以指定等待时间
					//latch.await(5000,TimeUnit.MILLISECONDS)
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("t2结束");
		},"t2").start();
		
		new Thread(()->{
			System.out.println("t1启动");
	
				for(int i=0;i<10;i++) {
					t.add(new Object());
					System.out.println("add"+i);
					if(t.size() == 5){
						//打开门闩而且不需要锁定任何对象
						latch.countDown();
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			
			
		}, "t1").start();
	}

}
























