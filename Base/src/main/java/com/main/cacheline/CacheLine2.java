package com.main.cacheline;
//不采用缓存行对其齐
public class CacheLine2 {
    private static class T {
        public volatile long x = 0L;
    }
    public static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for(long i = 0;i<1000_0000L;i++){
                arr[0].x = i;
            }
        });
        Thread thread2 = new Thread(()->{
            for(long i = 0;i<1000_0000L;i++){
                arr[1].x = i;
            }
        });

        final long star = System.nanoTime();
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println((System.nanoTime()-star)/100_0000);
    }
}
















































