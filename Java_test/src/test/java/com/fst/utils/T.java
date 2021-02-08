package com.fst.utils;

import cn.hutool.core.date.DateUnit;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class T {


    @Test
    public void t1() throws Exception {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        Date da  = dateTimeUtils.getNowTimeByNetWork();
        System.out.println(da.toString());
        System.out.println(DateTimeUtils.getWeekOfDate(da));
    }
    @Test
    public void t2(){
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());

    }
    @Test
    public void t3() throws Exception {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.offer("a");
        linkedList.offer("b");
        linkedList.offer("c");
        linkedList.offer("d");
        linkedList.offer("e");

        System.out.println(linkedList.pop());
        linkedList.offerFirst("a");
        System.out.println(linkedList.pop());
    }
    @Test
    public void t4(){
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
