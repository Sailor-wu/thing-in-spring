package org.psring.leetcode.practive.interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc 数对和
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
 * 示例 1: 输入: nums = [5,6,5], target = 11 输出: [[5,6]] 
 * 示例 2: 输入: nums = [5,6,5,6], target = 11 输出: [[5,6],[5,6]] 
 * 提示： nums.length <= 100000 
 * @author Sailor-why
 */
public class IQ_16_24 {

	
	public static void main(String[] args) {
		/**
		 * [6, 1, 7, 6, 5, 1, 0, 0, 5, -1]
6
		 */
		int target=
				6;
//				7;
//				11;
		int[] nums = 
//			{2, 1, 8, 6, 5, 7, -1, 3, 5, 5};
			{6, 1, 7, 6, 5, 1, 0, 0, 5, -1};
//			{5,6,5,6};
		List<List<Integer>> pairSums = new IQ_16_24().pairSums(nums, target);
		for (List<Integer> list : pairSums) {
			for (Integer i : list) {
				System.out.print(i+"--");
			}
			System.out.println("111");
		}
	}
	public List<List<Integer>> pairSums(int[] nums, int target) {
	 	int l = nums.length;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(l <=0 || l > 100000){
            return ret;
        }
        Arrays.sort(nums);
		int left = 0,right = (l-1);
        while(left < right){
            if(target - nums[right] == nums[left]){
                ret.add(Arrays.asList(nums[left],nums[right]));
                left++;
                right--;
            }else if(target>(nums[left]+nums[right])){
                left++;
            }else{
                right--;
            }
        }
		return ret;
			
	}
}
