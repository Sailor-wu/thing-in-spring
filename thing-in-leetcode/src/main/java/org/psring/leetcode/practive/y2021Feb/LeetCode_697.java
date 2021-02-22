package org.psring.leetcode.practive.y2021Feb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * desc 计算数组的度
 * 就是计算 滑动窗口的大小  根据度来分配窗口伸缩
 * @author Sailor-why
 */
public class LeetCode_697 {

	public static void main(String[] args) {
		int[] nums=
				{1, 2, 2, 3, 1};
		int array = new LeetCode_697().findShortestSubArray(nums);
		
		System.out.println(array);
	}
	
	public int findShortestSubArray(int[] nums) {
		int len = nums.length,pl = 0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>(len);
		
		// 计算原数组的频数
		for (int i = 0; i < len; i++) {
			Integer merge = map.merge(nums[i], 1, Integer::sum);
			pl = Math.max(pl, merge);
		}
		map.clear();
		
		int l = 0,r = 0,curPl = 0,res = len;
		while (r < len) {
			// 当前窗口内子数组的频数
			Integer merge = map.merge(nums[r++], 1, Integer::sum);
			curPl = Math.max(curPl, merge);
			// 如果当前窗口内子数组的频数和原数组出现的频数一致
			if(curPl == pl) {
				while (map.merge(nums[l], -1, Integer::sum) != pl -1) {
					l++;
				}
				curPl = pl -1;
				res = Math.min(res, r-l);
			}
		}
		return res;
	}
}
