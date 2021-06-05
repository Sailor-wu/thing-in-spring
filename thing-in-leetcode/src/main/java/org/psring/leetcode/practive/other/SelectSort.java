package org.psring.leetcode.practive.other;
/**
 * desc 选择排序
 * @author Sailor-why
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {
				5,8,9,6,1,3,2,4,7,0,0,0,4,45,55,55,55,8,22,0
		};
		
		int[] sort = selectSort3_1(arr);
		print(sort);
	}
	/**
	 * 每次都找最小值  替换
	 * @param arr
	 * @return
	 * int[]
	 */
	private static int[] selectSort2(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minP = i;// 默认最小的下标
			for (int j = i +1; j < length; j++) {
				// 比较取小
				minP = arr[j] < arr[minP]? j: minP;
			}
			swap(arr, i, minP);
		}
		return arr;
	}
	
	private static int[] selectSort2_1(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minP = i;// 默认最小的下标
			int maxP = length - i -1;
			if(maxP>(length / 2 -2)) {				
				for (int j = i +1; j < length; j++) {
					// 比较取小
					minP = arr[j] < arr[minP]? j: minP;
					// 比较取小
					maxP = arr[j] > arr[maxP]? j: maxP;
				}
				swap(arr, i, minP);
//				swap(arr, maxP, length - i -1);
				System.out.println("最打下标开始："+maxP+" - "+i+":"+arr[i]);
			}else {
				for (int j = i +1; j < length; j++) {
					// 比较取小
					maxP = arr[j] >= arr[maxP]? j: maxP;
				}
				swap(arr, i, maxP);
				System.out.println("最打下标开始："+maxP+" - "+i+":"+arr[i]);
			}
			
		}
		return arr;
	}
	
	
	private static int[] selectSort3_1(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minP = i;// 默认最小的下标
			int maxP = length-i-1;
			if(maxP<(length / 2 - 1)) {
				for (int j = i +1; j < length; j++) {
					// 比较取小
					minP = arr[j] < arr[minP]? j: minP;
					// 比较取da
					maxP = arr[j] >= arr[maxP]? j: maxP;
				}
				swap(arr, i, minP);
				
				swap(arr, length-i-1,maxP);
			}
			
		}
		return arr;
	}

	private static int[] selectSort(int[] arr) {
		
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minP = i;// 默认最小的下标
			int maxP = length-i-1;// 默认最大的下标
			if(minP == maxP) {
				break;
			}
			for (int j = i +1; j < length-i-1; j+=2) {
				// 比较取小
				minP = arr[(arr[j]<arr[j-1]?j:j-1)] < arr[minP]? (arr[j]<arr[j-1]?j:j-1): minP;
				maxP = arr[(arr[j]>=arr[j-1]?j:j-1)] >= arr[maxP]? (arr[j]>=arr[j-1]?j:j-1): maxP;
			}
			swap(arr, i, minP);
			swap(arr, length-i-1, maxP);
		}
		return arr;
	}

	

	/**
	 * 		优化版，找到最小和最大 分别替换前面和后面
	 * @param arr
	 * @return
	 * int[]
	 */
	static int [] selectSort1(int [] arr) {
		
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minP = i;// 默认最小的下标
//			int maxP = length-i;// 默认最大的下标
			int maxP = length-i-1;// 默认最大的下标
//			if(minP >= maxP) {
////				System.out.printf("length:%d,minP:%d",length,minP);
//				break;
//			}else {
//				System.out.printf("length:%d,minP:%d,maxP:%d  \n",length,minP,maxP);
//			}
			for (int j = i+1; j < length-i-1; j++) {
				// 比较取小
				minP = arr[j] < arr[minP]? j: minP;
				maxP = arr[j] > arr[maxP]? j: maxP;
			}
			swap(arr, i, minP);
//			for (int j = i +1; j < length-i-1; j++) {
//				// 比较取大
//				maxP = arr[j] > arr[maxP]? j: maxP;
//			}
			if(minP < maxP) {
//				swap(arr, length-i-1, maxP);
			}
				
		}
		return arr;
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
