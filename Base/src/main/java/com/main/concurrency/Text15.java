package com.main.concurrency;
/**
 * 
 * @date 2019年5月21日 下午2:17:05 @author fst @Email 820913504@qq.com
 * @purpose：不要以字符串常量作为锁定对象
 * 在下面的例子中，m1和m2其实锁定的是一个对象
 * 这种情况还会发生比较诡异的现象，比如你用到一个类库，在该类库中锁定了字符串hello
 * 但是你读不到源码，所以你也锁定了hello这时候就有可能发生非常诡异的死锁阻塞
 * 因为你的程序和你用到的类库不经意间使用了同一把锁
 *
 *jetty中出现过这个bug
 */
public class Text15 {
	String s1 = "hello";
	String s2 = "hello";
	
	void m1() {
		synchronized (s1) {
			
		}
	}
	void m2() {
		synchronized (s2) {
			
		}
	}
}
























