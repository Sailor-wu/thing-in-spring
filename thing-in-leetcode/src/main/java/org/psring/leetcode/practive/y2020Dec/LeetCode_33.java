package org.psring.leetcode.practive.y2020Dec;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *  a升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
	请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	示例 1：
	输入：nums = [4,5,6,7,0,1,2], target = 0
	输出：4
	示例 2：
	输入：nums = [4,5,6,7,0,1,2], target = 3
	输出：-1
		 提示： 
		1 <= nums.length <= 5000
		-10^4 <= nums[i] <= 10^4
		nums 中的每个值都 独一无二
		nums 肯定会在某个点上旋转
		-10^4 <= target <= 10^4 
 * @author Sailor-why
 *
 */
public class LeetCode_33 {
	
	public static void main(String[] args) {
		int nums [] = {4,5,6,7,0,1,2,3};
		int target = 3;
		HashMap hashMap;
		LinkedHashMap linkedHashMap;
		System.out.println(new LeetCode_33().search(nums, target));
	}
	
	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1, mid = 0;
		// 找到转换点
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] < nums[i - 1]) {
				mid = i;
				break;
			}
		}
		// 记录转换点
		int temp = mid;

		while (lo <= mid) {
			int mid1 = (lo + mid) / 2;
			if (nums[mid1] < target)
				lo = mid1 + 1;
			else if (nums[mid1] > target)
				mid = mid1 - 1;
			else
				return mid1;
		}
		mid = temp;
		while (mid <= hi) {
			int mid2 = (mid + hi) / 2;
			if (nums[mid2] < target)
				mid = mid2 + 1;
			else if (nums[mid2] > target)
				hi = mid2 - 1;
			else
				return mid2;
		}
		return -1;
	}
}
