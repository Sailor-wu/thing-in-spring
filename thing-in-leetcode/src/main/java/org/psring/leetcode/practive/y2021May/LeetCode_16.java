package org.psring.leetcode.practive.y2021May;

import java.util.Arrays;

/**
 * desc
 * 
 * @author Sailor-why 给定一个包括 n 个整数的数组 nums 和
 *         一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *         示例： 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 +
 *         2 + 1 = 2) 。 提示： 3 <= nums.length <= 10^3 -10^3 <= nums[i] <= 10^3
 *         -10^4 <= target <= 10^4
 * 
 */
public class LeetCode_16 {

	public static void main(String[] args) {

		int target =
				1;
		int[] nums=
				{-1,2,1,-4};
		System.out.println(threeSumClosest(nums, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int retTarget = nums[0] + nums[1] + nums[2];
		// 每三个数为一组
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1, end = nums.length - 1;
			// 双指针
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (Math.abs(target - sum) < Math.abs(target - retTarget)) {
					retTarget = sum;
				}
				if (sum > target)
					end--;
				else if (sum < target)
					start++;
				else
					return retTarget;
			}
		}
		return retTarget;
	}
}
