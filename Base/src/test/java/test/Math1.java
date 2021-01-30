package test;

import org.junit.Test;

public class Math1 {
    @Test
    public void m1(){
        long a = Math.round(-1.5);
        System.out.println(a);
        long b1 = Math.round(-1.6);
        System.out.println(b1);

        long b2 = Math.round(1.5);
        System.out.println(b2);
        long b3 = Math.round(1.6);
        System.out.println(b3);

    }
}
