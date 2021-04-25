package org.psring.leetcode.practive.interview_questions;
/**
 * desc  连续数列
 * <p> 连续求最大值，最终返回最大
 * @author Sailor-why
 */
public class IQ_16_17 {
	
	public static void main(String[] args) {
		int arr [] =
			{-2,1,-3,4,-1,2,1,-5,4};
		int i = maxSubArray(arr);
		System.out.println(i);
	}

	public static int maxSubArray(int[] nums) {
		// 定义最大  和 
		int max = Integer.MIN_VALUE,  sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// 判断当前的值和之前的和相加，是否大于当前，大于继续加。不大重新记录
			if(sum + nums[i] < nums[i]) sum = 0;
			sum+=nums[i];
			// 更新最大值
			if(max < sum) max = sum;
		}
		return max;// 返回最大的值
	}
}
