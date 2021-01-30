package com.fst.suanfa;


import java.util.Random;

class QuickSortOther {
	public static void main(String[] args) {
		QuickSortOther quickSort = new QuickSortOther();
		int a1[] = quickSort.creatList();

        System.out.println("排序前");
        for (int s:a1) {
            System.out.print(s+",");
        }
		quickSort.quickSort(a1,0,a1.length-1);

		System.out.println("排序后");
		for(int i=0;i<a1.length-2;i++){
			if(a1[i]>a1[i+1]){

				System.out.println("chuchuo   " +i);
			}

		}

		for (int s:a1) {
			System.out.print(s+",");
		}
	}
	public int[] creatList(){
		Random random = new Random();

		int list[] = new int[40];
		for(int i = 0;i<list.length;i++){
			int temp = random.nextInt(10);
			list[i]= temp;
//            if(temp == 10){
//                System.out.println(temp);
//            }

		}
		return list;
	}

	private static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			// 找寻基准数据的正确索引
			int index = getIndex(arr, low, high);

			// 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
			//quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
			//做地柜
			quickSort(arr, low, index - 1);
			//右递归
			quickSort(arr, index + 1, high);
		}

	}

	private static int getIndex(int[] arr, int low, int high) {
		// 基准数据
		int tmp = arr[low];
		while (low < high) {
			// 当队尾的元素大于等于基准数据时,向前挪动high指针
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			// 如果队尾元素小于tmp了,需要将其赋值给low
			arr[low] = arr[high];
			// 当队首元素小于等于tmp时,向前挪动low指针
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			// 当队首元素大于tmp时,需要将其赋值给high
			arr[high] = arr[low];

		}
		// 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
		// 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
		arr[low] = tmp;
		return low; // 返回tmp的正确位置
	}
}