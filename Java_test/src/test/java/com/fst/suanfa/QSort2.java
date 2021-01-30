package com.fst.suanfa;

import java.util.Random;

public class QSort2 {
    public static void main(String[] args) {
        QSort2 sort2 = new QSort2();
        int a[] = sort2.creatList();

        for (int s:a) {
            System.out.print(s + ",");
        }

        sort2.Sort(a,0,a.length-1);
        System.out.println();
        for (int s:a) {
            System.out.print(s + ",");
        }

    }
    public int[] creatList(){
        Random random = new Random();

        int list[] = new int[50];
        for(int i = 0;i<list.length;i++){
            int temp = random.nextInt(10);
            list[i]= temp;
        }
        return list;
    }

    public void Sort(int[]arr, int left , int right){

        if(left<right){
            int index = getIndex(arr,left,right);

            Sort(arr,left,index-1);
            Sort(arr,index+1,right);
        }

    }
    public int getIndex(int[]arr,int l ,int r){
        int temp = arr[l];

        while (l<r){
            while (l<r && arr[r]>=temp){
                r--;
            }
            arr[l] = arr[r];
            while (l<r && arr[l]<=temp){
                l++;
            }
            arr[r] = arr[l];

        }
        arr[l]=temp;
        return l;
    }


}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    