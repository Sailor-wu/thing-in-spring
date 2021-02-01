package org.psring.leetcode.practive.y2021Feb;

import java.util.Arrays;

/**
 * desc 糖果公平交换
 * @author Sailor-why
 */
public class LeetCode_888 {

	public static void main(String[] args) {
		int [] A = {2};
		int [] B = {1,3};
		int  [] ret  = new LeetCode_888().findCandySwap(A,B);
		System.out.println(Arrays.toString(ret));
	}

	private int[] findCandySwap(int[] a, int[] b) {
		int diff = 0;
		boolean [] flags = new boolean[100001];
		
		for (int num : a) {
			diff-=num;
		}
		for (int num : b) {
			diff+=num;
			flags[num] = true;
		}
		diff/=2;
		for (int num : a) {
			int numB = num +diff;
			if(numB > 0 && numB < 100001 && flags[numB]) {
				return new int[] {num,num+diff};
			}
		}
		return null;
	}
}
