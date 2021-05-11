package org.psring.leetcode.practive.y2021May;

import java.util.LinkedList;
import java.util.List;

/**
 * desc 非递增的最小子序列
 * @author Sailor-why
 *   	 示例 1：
	输入：nums = [4,3,10,9,8]
	输出：[10,9] 
	解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。 
	示例 2：
	输入：nums = [4,4,7,6,7]
	输出：[7,7,6] 
	解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。  
	示例 3：
	输入：nums = [6]
	输出：[6] 
	
	约束：
	1 <= nums.length <= 500
	1 <= nums[i] <= 100

 */
public class LeetCode_1403 {

	public List<Integer> minSubsequence(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
		
		int n = nums.length;
		int [] c = new int [101]; // 根据约束条件判断
		int sum = 0;
		for (int i : nums) {
			sum+=i;
			c[i]++;
		}
		
		sum /=2;
		int canSum = 0;
		int index = 0;
		
		out:for(int i = 100;i>=0;i--) {
			
			while (c[i] > 0) {
				c[i]--;
				list.add(i);
				canSum +=  i;
				if(canSum > sum)
					break out;
			}
			
		}
		
		return list;
	}
}
