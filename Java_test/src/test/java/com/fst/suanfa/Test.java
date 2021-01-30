package com.fst.suanfa;

public class Test {
    @org.junit.Test
    public void t1(){
        //MD5 md5 = new MD5();
        //System.out.println("->"+md5.start("asd"));

        System.out.println("->"+MD5.getMd5().start("asd"));
        System.out.println("->"+MD5.getMd5().start("asd"));
        //System.out.println("->"+MD5.getMd5().start("asd"));
    }
}
