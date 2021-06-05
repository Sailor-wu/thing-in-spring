package org.psring.leetcode.practive.other;

/**
 * desc 归并排序
 * 
 * @author Sailor-why
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {
//				5, 8, 9, 6, 1, 3, 2, 4, 7, 0, 0, 0, 4, 45, 55, 55, 55, 8, 22, 0
//				5, 8, 9, 6, 1, 3, 2, 4, 7 
				1,4,7,8,8,3,6,6,9,11
				};

		int[] sort = mergeSort(arr);
		print(sort);
	}

	
	
	public static int []  mergeSort(int[] arr) {

		int mid = arr.length >> 1;
		int i = 0, j = mid+1 ,k=0;
		int temp [] = new int[arr.length];
		while (i <= mid && j < arr.length) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j < arr.length) {
			temp[k++] = arr[j++];
		}
		return temp;
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
