package org.psring.leetcode.practive.y2021Apr;

import java.util.HashMap;

public class LeetCode_137 {

	public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)) {
            	map.put(i, map.get(i)+1);
            }else {
            	map.put(i, 1);
			}
        }
        for (int k : map.keySet()) {
			if(map.get(k) == 1) {
				return k;
			}
		}
        return -1;
    }
	
}
