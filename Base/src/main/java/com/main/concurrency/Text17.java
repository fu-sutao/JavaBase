package com.main.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @date 2019年5月21日 下午3:14:26 @author fst @Email 820913504@qq.com
 * @purpose：
 *这里使用wait和notify做到，wait会释放锁，notify不会释放锁
 *这里需要注意的是运用这种方法必须让t2先执行，也就是让t2监听才可以
 *
 *notify之后t1必须释放锁，t2退出后，也必须notify，通知t1继续执行
 *
 *使用Latch（门闩 ）代替wait notify来进行通知
 *好处是通信方式简单，同时也可以指定等待时间
 *使用await和countdown代替wait和notify
 *CountDownLatch不涉及锁定，当count的值为零时，当前线程继续运行
 *当不涉及同步只涉及线程通讯的时候，用synchronized wait notify就显得太重了
 *这时应该考虑countdownlathe/cyclicbarrier/semaphore
 */
public class Text17 {
	List lists = new ArrayList();
	public void add(Object o) {
		lists.add(o);
	}
	public int size() {
		return lists.size();
	}
	public static void main(String[] args) {
		// 
		
		Text17 t = new Text17();
		final Object lock = new Object();
		new Thread(()->{
			synchronized(lock) {
				if(t.size() != 5) {
					try {
						lock.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("t2结束");
				//通知t1继续执行
				lock.notify();
			}
			
		},"t2").start();
		
		new Thread(()->{
			System.out.println("t1启动");
			synchronized (lock) {
				for(int i=0;i<10;i++) {
					t.add(new Object());
					System.out.println("add"+i);
					if(t.size() == 5){
						lock.notify();
						//释放锁让t2得以执行
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			
		}, "t1").start();
		
	}
}


























