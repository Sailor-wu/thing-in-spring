package org.psring.leetcode.practive.y2021Feb;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_448 {
	public static void main(String[] args) {
		
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		boolean[] exists = new boolean[nums.length];

        for (int n : nums) {
            exists[n - 1] = true;
        }

        List<Integer> missings = new ArrayList<>(nums.length);
        for (int i = 0; i < exists.length; i++) {
            if (! exists[i]) {
                missings.add(i + 1);
            }
        }
        
        return missings;
    }
}
