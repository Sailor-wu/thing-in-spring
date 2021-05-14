package org.psring.leetcode.practive.y2021May;
/**
 * desc 查找数组里面的唯一重复数
 * @author Sailor-why
 * 	给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 	2 <= n <= 3 * 104
	nums.length == n + 1
	1 <= nums[i] <= n
	nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
 */

import java.util.HashSet;
import java.util.Set;


public class LeetCode_287 {

	public static void main(String[] args) {
		
		LeetCode_287 code_287 = new LeetCode_287();
		int[] nums = {
//				1,3,4,2,2
//				3,1,3,4,2
//				1,1
				1,0,2
				};
		int duplicate = code_287.findDuplicate(nums);
		System.out.println(duplicate);
		
	}
	// hash做法
	Set<Integer> set = new HashSet<Integer>();
	public int findDuplicate1(int[] nums) {
		for (int i : nums) {
			if(set.contains(i)) {
				return i;
			}else {
				set.add(i);
			}
		}
		return -1;
    }
	
	// 快慢指针
	public int findDuplicate(int[] nums) {
		int fast = 0,low = 0;
		while (true) {
			low = nums[low];
			fast = nums[nums[fast]];
			if(fast == low) {
				fast = 0;
				while(nums[low] != nums[fast]) {
					low = nums[low];
					fast = nums[fast];
				}
				return nums[low];
			}
		}
	}
	
	
	
	
}
