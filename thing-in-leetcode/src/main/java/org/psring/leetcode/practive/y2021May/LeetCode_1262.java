package org.psring.leetcode.practive.y2021May;

/**
 * desc 返回数组中能被3 整除的最大和
 * 
 * @author Sailor-why
 */
public class LeetCode_1262 {

	public static void main(String[] args) {
		int [] aa = {
//				3,6,5,1,8
				1,2,3,4,4
//				4
		};
		int i = maxSumDivThree(aa);
		
		System.out.println(i);
		
	}

	public static int maxSumDivThree(int[] nums) {
		
		int dp[] = { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };

		for (int i : nums) {
			
			int[] dp2 = { 0, 0, 0 };
			
			for (int j = 0; j < 3; j++) {
				dp2[(j + i) % 3] = Math.max(dp[(i + j) % 3], dp[j] + i);
			}
			dp = dp2;
		}

		return dp[0];
	}
}
