package com.main.concurrency;

public class Text1 {
	/**
	 * 2019-5-19
	 * synchroized关键字
	 * 对某个对象加锁
	 *
	 * synchronized 可以制作一个代码块  也可以修饰方法  public前  或返回类型前
	 * 
	 */





	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	class T{
		private int count1 = 10;
		private Object o = new  Object();
		public void m() {
			synchronized(o) {//一般填写this
				count1--;  //执行这段代码先向o对象申请锁锁的信息记录在堆里不是引用里
				System.out.println(Thread.currentThread().getName()+"count="+count1);
			}
		}
	}

	class T2{
		private int count1 = 10;
		private Object o = new  Object();
		public void m() {
			synchronized(this) {//锁定的是一个对象
				count1--;//执行这段代码必须先拿到this的锁
				System.out.println(Thread.currentThread().getName()+"count="+count1);
			}
		}
	}

	class T3{
		private int count1 = 10;
		private Object o = new  Object();
		public synchronized void m() {
			//等同于Text2
			count1--;//执行这段代码必须先拿到this的锁
			System.out.println(Thread.currentThread().getName()+"count="+count1);

		}
	}




}
class T4{
	private static int count1 = 10;
	private Object o = new  Object();
	public static void m() {
		//等同于Text2
		count1--;//执行这段代码必须先拿到this的锁
		System.out.println(Thread.currentThread().getName()+"count="+count1);

	}
	public static void mm() {
		synchronized(com.main.concurrency.T4.class) {//T4.class相当于T4的一个对象
			//因为是static的所以没有this这时用T4.class
			count1--;
		}
	}
}





















