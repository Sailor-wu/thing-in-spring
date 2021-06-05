package org.psring.leetcode.practive.other;

/**
 * desc 插入排序
 * 
 * @author Sailor-why
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {
//				5, 8, 9, 6, 1, 3, 2, 4, 7, 0, 0, 0, 4, 45, 55, 55, 55, 8, 22, 0
				5, 8, 9, 6, 1, 3, 2, 4, 7 
//				1,2,3,4,5,6,7,8,9
				};

		insertionSort1_2(arr);
		print(arr);
	}

	
	
	public static void insertionSort(int[] arr) {
		int count = 0;
//		boolean flg = false;
		for (int j = 0; j < arr.length-1; j++) { //5
//			flg = false;
			for (int k = j; k < arr.length-1; k++) { //
				if (arr[k + 1] < arr[j]) {					
					swap(arr, j, k + 1);
//					flg = true;
				}
				count++;
			}
//			if(!flg) {
//				break;
//			}
		}
		System.out.printf("总共执行了：%d次。\n",count);
	}
	public static void insertionSort1_1(int[] arr) {
		int count = 0;
		for (int j = 1; j < arr.length; j++) { //5
			for (int k = j; k >0 && arr[k - 1] > arr[k]; k--) { //
//				if (arr[k - 1] > arr[k]) {					
					swap(arr, k-1, k);
//				}
				count++;
			}
		}
		System.out.printf("总共执行了：%d次。\n",count);
	}
	public static void insertionSort1_2(int[] arr) {
		int count = 0;
		
		for (int j = 1; j < arr.length; j++) { //5
			int value = arr[j];
			int t = j -1;
			for (; t>=0 && arr[t] > value; t--) {
				count++;
//				if(arr[t] > value) {
					arr[t+1] = arr[t];
//				}else {
//					break;
//				}
			}
			arr[t+1] = value;
		}
		System.out.printf("总共执行了：%d次。\n",count);
	}
	private static void swap(int[] arr, int i, int minP) {
		int temp = arr[i];
		arr[i] = arr[minP];
		arr[minP] = temp;
	}

	private static void print(int[] sort) {
		for (int i = 0; i < sort.length; i++) {
			System.out.print(sort[i] + " ");
		}
	}
}
