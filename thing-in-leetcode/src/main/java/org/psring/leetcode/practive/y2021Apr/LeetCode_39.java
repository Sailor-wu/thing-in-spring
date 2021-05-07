package org.psring.leetcode.practive.y2021Apr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_39 {

	public static void main(String[] args) {
		int target =
				7;
		int[] candidates=
		{2,3,6,7};
		List<List<Integer>> list2 = new LeetCode_39().combinationSum(candidates, target);
		for (List<Integer> list : list2) {
			System.out.println(list);
		}
	}
	
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int j = 0;
		int len = candidates.length;
		ArrayList<Integer> list2;
		for (int i = 0; i < len; i++) {
			
			if(candidates[i] > target) {
				continue;
			}else if(candidates[i] == target) {
				list2 = new ArrayList<Integer>();
				list2.add(candidates[i]);
				list.add(list2);
				continue;
			}
			j = i+1;
			int k = candidates[i];
			while (j < len) {
				list2 = new ArrayList<Integer>();
				k = k + candidates[j];
				if(k > target) {
					break;
				}else if(k < target) {
					list2.add(candidates[j]);
					j++;
				}else if(k == target) {
					list.add(list2);
				}
			}
		}
		return list;
    }
}
