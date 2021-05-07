package org.psring.leetcode.practive.y2021May;

import java.util.Arrays;

/**
 * desc 正整数数组 相互除乙下一个数   得到最大的商  （最优除法）
 * @author Sailor-why
 */
public class LeetCode_553 {

	public static void main(String[] args) {
		LeetCode_553 code_553 = new LeetCode_553();
		int[] nums =
				{2};
		
		String string = code_553.optimalDivision(nums);
		System.out.println(string);
	}
	private String optimalDivision(int[] nums) {
		StringBuilder sb = new StringBuilder();
		// 直接循环
		for (int i = 0; i < nums.length; i++) {
			if(i == 1) {
				sb.append("("); // 非 第一个添加开始括号
			}
			sb.append(nums[i]);
			// 不等于最后一个  添加 / 符号
			if(i < nums.length - 1) {
				sb.append("/");
			}else { // 等于最后一个，添加结束括号
				sb.append(")");
			}
		}
		// 判断 整个数组长度是否大于 2
		if(nums.length <= 2) {
			// 需要去掉 括号
			return sb.toString().replaceAll("(", "").replaceAll(")", "");
		}
		
		return sb.toString();
	}
	public String optimalDivision1(int[] nums) {
		int len = nums.length;
		StringBuilder sb = new StringBuilder();
		if(len == 1) return nums[0]+"";
		if(len == 2) return nums[0]+"/"+nums[1];
		// 开始添加开始括号
		sb.append(nums[0]+"/("+nums[1]);
		for (int i = 2; i < len; i++) {
			sb.append("/"+nums[i]);
		}
		sb.append(")"); // 结束 添加结束括号
		return sb.toString();
    }
	
}
