package com.fst.suanfa;

import org.junit.Test;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int a1[] = quickSort.creatList();

//        System.out.println("排序前");
        for (int s:a1) {
            System.out.print(s+",");
        }


        quickSort.Quick(a1,0,a1.length-1);


        System.out.println(quickSort.chack(a1));

        for (int s:a1) {
            System.out.print(s+",");
        }

    }

    public boolean chack(int[] a1){
        boolean result = true;
        for(int i=0;i<a1.length-1;i++){
            if(a1[i]>a1[i+1]){
                result = false;
                System.out.print("第" +i);
            }

        }
        return result;
    }


    public int[] creatList(){
        Random random = new Random();

        int list[] = new int[50];
        for(int i = 0;i<list.length;i++){
            int temp = random.nextInt(10);
            list[i]= temp;
//            if(temp == 10){
//                System.out.println(temp);
//            }

        }
        return list;
    }
//    public void Sort(int[]arr, int left , int right){
//
//        if(left<right){
//            int index = Quick(arr,left,right);
//
//            Sort(arr,left,index-1);
//            Sort(arr,index+1,right);
//        }
//
//    }

    public void Quick(int arr[],int left,int right){
        if(left<right){

            int l = left;
            int r = right;

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
            Quick(arr,left,l-1);
            Quick(arr,l+1,right);
        }



    }


}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    