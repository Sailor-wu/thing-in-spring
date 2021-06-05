package org.psring.leetcode.practive.other;

/**
 * desc 冒泡排序
 * 
 * @author Sailor-why
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 9, 6, 1, 3, 2, 4, 7, 0, 0, 0, 4, 45, 55, 55, 55, 8, 22, 0 };

		bubbleSortDesc(arr);
		print(arr);
	}

	/**
	 * 冒牌降序
	 * 
	 * @param arr void
	 */
	private static void bubbleSortDesc(int[] arr) {
		boolean flg = false;
		for (int i = arr.length - 1; i > 0; i--) {
			flg = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[j + 1]) {
					swap(arr, j, j + 1);
					flg = true;
				}
			}
			if (!flg)
				return;
		}

	}

	/**
	 * 冒牌升序
	 * 
	 * @param arr void
	 */
	private static void bubbleSort(int[] arr) {
		boolean flg = false;
		for (int i = arr.length - 1; i > 0; i--) {
			flg = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flg = true;
				}
			}
			if (!flg)
				return;
		}

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
