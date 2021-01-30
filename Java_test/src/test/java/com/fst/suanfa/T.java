package com.fst.suanfa;

public class T {
    public static void main(String[] args) {
        int [] nums = {3,2,3};
//        int [] nums = {3,2,4};//1 2
        int target = 6;
        twoSum(nums,target);
    }

    public static int[] twoSum(int[] nums, int target) {

        int [] a = new int [2];
        for(int i=0;i<nums.length;i++){
            System.out.println("i="+i);
            System.out.println(nums.length-i-1);
            for(int j=i+1;j<nums.length;j++){
                System.out.println("j=" + j);
                if(nums[i]+nums[j]==target){
                    a[0]=i;a[1]=j;
//                    return a;
                    System.out.println(""+a[0]+"*****"+a[1]);
                }
            }
        }
    return a;
    }




}
