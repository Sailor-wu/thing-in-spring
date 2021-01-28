package org.psring.leetcode.practive.y2021Jan;

import java.util.Arrays;

/**
 * desc 返回数组的中心索引
 * @author Sailor-why
 */
public class LeetCode_724 {

	public static void main(String[] args) {
		
		
		int[] nums = 
//				{1,2,3,6,2,4};
//			{-1,-1,-1,0,1,1};
			{-1,-1,0,1,1,0};
		int i = new LeetCode_724().pivotIndex(nums );
		System.out.println(i);
		
		
	}
	
	private int pivotIndex(int[] nums) {
		int total = 0;
		for (int i : nums) {
			total += i;
		}
		int lSum = 0;
		int rSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i!=0) {				
				lSum +=nums[i-1];
			}
			rSum = total - nums[i] - lSum;
			if(lSum == rSum) {
				return i;
			}
		}
		return -1;
	}

	// 1
	public int pivotIndex1(int [] nums) {
		int total = Arrays.stream(nums).sum();
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(2*sum + nums[i]  == total) {
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}
	
	
}
