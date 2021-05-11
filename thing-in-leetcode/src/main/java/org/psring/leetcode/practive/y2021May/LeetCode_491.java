package org.psring.leetcode.practive.y2021May;
/**
 * desc 递增子序列
 * @author Sailor-why
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_491 {

	public static void main(String[] args) {
		int [] arr = 
			{4, 6, 7, 7};
		LeetCode_491 code_491 = new LeetCode_491();
		code_491.findSubsequences(arr);
		for (List<Integer> i : code_491.res) {
			System.out.println(i);
		}
	}
	
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> findSubsequences(int [] nums){
		//
		dfs(nums,-1,new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, int idx, ArrayList<Integer> curList) {
		// 只要当前的递增序列长度大于 1 ，就加入到结果 res 中，继续递增搜索下一个值。
		if(curList.size() > 1)
			res.add(new ArrayList<Integer>(curList));
		
		// 在 idx + 1 nums.length - 1 范围内遍历搜索递增序列的下一个值
		// 使用 set 对搜索结果去重
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = idx + 1; i < nums.length; i++) {
			// set 中存在就跳过
			if(set.contains(nums[i]))
				continue;
			set.add(nums[i]);
			// 如果 nums[i] >= nums[idx] 的话，说明出现了新的递增序列  
			
			if(idx == -1 || nums[i] >= nums[idx]) {
				curList.add(nums[i]);
				dfs(nums, i, curList);
				curList.remove(curList.size() - 1);
			}
		}
		
	}
	
}
