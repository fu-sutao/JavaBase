package com.main;
/**
 * 连续签到问题
 */

import java.util.*;

public class Test {

    static Set b = new HashSet();
    public static void main(String[] args) {
        ArrayList<Integer> as = new ArrayList<>();
        as.add(1);//周一如果没签到就把这行注掉。
        as.add(2);
        as.add(3);
        as.add(4);
        as.add(5);
        as.add(6);
        as.add(7);

//        System.out.println(as.contains(1));
        System.out.println(s(as));
    }
    public static int s(ArrayList<Integer> a){
        int temp = 0;
        int max1 = 0;
        if(a.size()!=0){
            max1 = Collections.max(a);
            for(int i=0;i<a.size();i++){
                if(a.contains(max1-i-1)){
                    temp++;
                }else {
                    temp++;
                    return temp;
                }

            }
        }
        return temp;
    }
}
