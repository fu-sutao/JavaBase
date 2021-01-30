package com.fst.mianshi;

import org.junit.Test;

public class InstanceofTest {
    @Test
    public void t(){
        Son son = new Son();
        System.out.println(son instanceof Father);
        System.out.println(son instanceof Son);
    }

    @Test
    public void t2(){
        long a = Math.round(-1.5);
        System.out.println(a);
        long b = Math.round(1.5);
        System.out.println(b);
    }

}
