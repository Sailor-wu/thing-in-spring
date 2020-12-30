package org.psring.leetcode.practive.y2020Dec;

import java.util.Arrays;

/**
 * .秤石头
 * @author Sailor-why
 *
 */
public class LeetCode_1046 {

	public static void main(String[] args) {
//		int [] stones = {2,7,4,1,8,1,1};
		int [] stones = {1,12,9};
		System.out.println(new LeetCode_1046().lastStoneWeight(stones));
	}

	private int lastStoneWeight(int[] stones) {
		if(stones.length == 1)
			return stones[0];
		if(stones.length == 2) {
			return Math.abs(stones[0]-stones[1]);
		}
		Arrays.sort(stones);
		printArr(stones);
		if(stones[stones.length- 2] != 0) {
			stones[stones.length-1] =stones[stones.length-1] - stones[stones.length-2];
			stones[stones.length-2] = 0;
			return lastStoneWeight(stones);
		}else {
			return stones[stones.length - 1];
		}
		 
	}

	private int lastStoneWeight1(int[] stones) {
		// 升序排序
		int len = stones.length ;
		if(len == 0 ) 
			return 0;
		if(len == 1 ) 
			return stones[0];
		if(len == 2 ) {
			Arrays.sort(stones);
			return stones[len - 1] -stones[len - 2];
		}
		Arrays.sort(stones);
		printArr(stones);
		for (int i = len; i >=0; i--) {
			stones[len - 1] = stones[len - 1] -stones[len - 2];
			stones[len - 2] = 0;
			Arrays.sort(stones);
			if(stones[len-2] == 0) {
				break;
			}
			printArr(stones);
		}
		return stones[len-1];
	}
	
	private void printArr(int [] arr) {
		for (int i : arr) {
			System.out.print("\t"+i);
		}
		System.out.println();
	}
}
