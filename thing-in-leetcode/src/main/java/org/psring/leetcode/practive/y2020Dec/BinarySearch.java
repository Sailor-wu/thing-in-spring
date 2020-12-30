package org.psring.leetcode.practive.y2020Dec;

import java.util.Arrays;

/**
 * .查找递增数组中第一个大于等于某个给定值的元素(二分查找)
 * @author Sailor-why
 *
 */
public class BinarySearch {

	
	public static void main(String[] args) {
		System.out.println((7+8)/2);
		int [] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//=null;//= new int [] {1};//,5,15,48,9,11,3,5
//		Arrays.sort(arr);
//		for (int i : arr) {
//			System.out.print("\t" +i);
//		}
		int num =10;
		int index = new BinarySearch().findFirstEqualtOrLarger(arr,num);
		System.out.println("\n"+index);
	}

	/**
	 * desc 二分行查找  获取间位置下标
	 * @author {Sailor-why}
	 * 
	 */
	private int findFirstEqualtOrLarger(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0, right = arr.length-1  ,i=0;
		
		while (left != right) {
			// 切分下标
			int mid = left +(right-left)/2;
			System.out.println("--"+(++i));
			if(arr[mid] > num) {
				// 如果切分下标值 大于 目标值 ，那么继续在前半部分查找
				right = mid;
			}else if(arr[mid] < num) {
				// 如果切分下标值 小于 目标值 ，那么继续在后半部分查找
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
