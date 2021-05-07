package org.psring.leetcode.practive.y2021Apr;

import java.util.HashMap;
import java.util.HashSet;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * desc 青蛙过河   使用记忆化 + 递归
 * @author Sailor-why
 */
public class LeetCode_403 {

	public static void main(String[] args) {
		int[] stones=
				{0,1,3,5,6,8,12,17};
		boolean canCross = new LeetCode_403().canCross(stones);
		System.out.println(canCross);
	}
	
	public boolean canCross(int[] stones) {
//		HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
//		return helper(stones,0,0,hashMap);
		return helper(stones,0,0);
    }

	private HashSet<Integer> set = new HashSet<Integer>();
	private boolean helper(int[] stones, int idx, int k) {
		Integer key = idx*1000+k;
		if(set.contains(key)) {
			return false;
		}else {
			set.add(key);
		}
		for (int i = idx + 1; i < stones.length; i++) {
			int gap = stones[i] - stones[idx];
			if(gap >= k-1 && gap <= k+1) {
				if(helper(stones, i, gap)) {
					return true;
				}else if(gap > k+1) {
					break;
				}else if(gap < k-1) {
					continue;
				}
			}
		}
		
		return idx == stones.length -1;
	}

//	private boolean helper(int[] stones, int k, int idx, HashMap<Integer, Boolean> hashMap) {
//		// 生成key
//		int key = idx * 1000 + k ;
//		if(hashMap.containsKey(key)) {
//			return false;
//		}else {
//			hashMap.put(key, true);
//		}
//		for (int i = idx + 1; i < stones.length; i++) {
//			// 算出第i到当前石头的距离
//			int gap = stones[i] - stones[idx];
//			// 这一步能跳到【k-1,k+1】范围
//			if(gap >= k-1 && gap <= k+1) {
//				if(helper(stones, i, idx, hashMap)) {
//					return true;
//				}
//			}else if(gap > k +1) {
//				break;
//			}
//		}
//		return idx == stones.length -1;
//	}
	
}
