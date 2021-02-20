package org.psring.leetcode.practive.y2021Feb;
/**
 * 
 * desc
 * @author Sailor-why
 */
public class LeetCode_1004 {

	public static void main(String[] args) {
		int K = 
//				3;
				2;
		int[] A =
				{1,1,1,0,0,0,1,1,1,1,0};
//			{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int ones = new LeetCode_1004().longestOnes(A, K);
		System.out.println(ones);
	}
	public int longestOnes(int [] A , int K) {
		int l = 0, r = 0;
		while (r < A.length) {
			if(A[r++] == 0)K--;
			if(K<0 && A[l++] ==0)K++;
		}
		return r - l;
	}
	public int longestOnes1(int [] A , int K) {
		int l = 0, r = 0, res = 0;
		while (r < A.length) {
			if(A[r] == 0) {
				if(K == 0) {
					while (A[l] ==1) {
						l++;
					}
					l++;
				}else {
					K--;
				}
			}
			res = Math.max(res, ++r - l);
		}
		return res;
	}
}
