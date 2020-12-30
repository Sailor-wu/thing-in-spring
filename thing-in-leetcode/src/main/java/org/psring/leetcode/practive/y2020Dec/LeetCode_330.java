package org.psring.leetcode.practive.y2020Dec;

public final class LeetCode_330 {

	public int minPatches(int[] nums, int n) {
		int patches = 0;
		long x = 1;
		int length = nums.length, index = 0;
		while (x <= n) {
			if (index < length && nums[index] <= x) {
				x += nums[index];
				index++;
			} else {
				x *= 2;
				patches++;
			}
		}
		return patches;
	}
	
	public static void main(String[] args) {
		int nums [] = {1,3};
		int n = 6;
		LeetCode_330 code_330 = new LeetCode_330();
		code_330.minPatches(nums, n);
	}
}
