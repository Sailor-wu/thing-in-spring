package org.psring.leetcode.practive.y2021Jan;

import java.util.Arrays;

/**
 * desc 三个数的最大乘积
 * 	给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

	输入: [1,2,3]
	输出: 6
	
	输入: [1,2,3,4]
	输出: 24
	
	输入:[-100,-98,-9,2,3,4]
	输出: 39200
 * @author Sailor-why
 */
public class LeetCode_628 {

	public static void main(String[] args) {
		int[] nums =
				{-100,98,-9,2,3,4};
		int product = new LeetCode_628().maximumProduct1(nums );
		System.out.printf("最大的乘积是：%s.",product);
	}
	/**
	 * desc 思路 排序数组，或者遍历数组。在做操作
	 * 1.不存在负数的情况 找到三个最大的数，进行相乘得到最大的值。
	 * 2.存在负数，最少两个以上，那么就有可能是负负得正乘以 非负最大
	 * @param nums
	 * @return 返回最大的乘积
	 * int
	 */
	public int maximumProduct(int [] nums) {
		int len  = nums.length;
        if(len ==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        if(len==2){
            return nums[0]*nums[1];
        }
        // 排序
        Arrays.sort(nums);
        return Math.max(nums[len-1] * nums[len-2]*nums[len-3],nums[0] * nums[1]*nums[len-1]); 
	}
	/**
	 * desc 直接遍历数组  获取最小的两个，获取最大的三个
	 * @param nums
	 * @return
	 * int
	 */
	public int maximumProduct1(int [] nums) {
		int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE,
				max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
		for (int i : nums) {
			// 记录两个最小的 
			if(i <= min1) {
				min2 = min1;
				min1 = i;
			}else if(i < min2){
				min2 = i;
			}
			// 记录三个最大的
			if(i >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			}else if(i >= max2) {
				max3 = max2;
				max2 = i;
			}else if(i >=max3) {
				max3 = i;
			}
		}
		return Math.max(min1*min2*max1, max1*max2*max3);
	}
}
