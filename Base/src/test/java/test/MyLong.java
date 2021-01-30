package test;

import org.junit.Test;

public class MyLong {
    private static int x = 0,y = 0;
    private static int a = 0,b = 0;
    @Test
    public void a(){
        long a = 10_00L;
        System.out.println(a);
        System.out.println(System.nanoTime());
    }
//    乱序执行证明
    @Test
    public void b() throws InterruptedException {

//        volatile 可见性  阻止乱序执行

        long i = 0;
        while (true){
            x = 0; y = 0;
            a = 0; b = 0;
//            如果不存在乱序执行，x和y必定有一个为0
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread one1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();one1.start();
            one.join();one1.join();
            i++;
            String result = "第" + i + "次  x = " + x+"   y = "+y;

            if(x ==0 && y == 0){
                System.out.println(result);
                break;
            }
        }
    }
}
















































