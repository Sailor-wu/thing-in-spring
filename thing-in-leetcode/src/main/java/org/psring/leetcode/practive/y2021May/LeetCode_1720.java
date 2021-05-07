package org.psring.leetcode.practive.y2021May;
/**
 * desc 解码异或 后的数组
 * @author Sailor-why
 */
public class LeetCode_1720 {

	public static void main(String[] args) {
		LeetCode_1720 code_1720 = new LeetCode_1720();
		int first=
//				1;
				4;
		int[] encodeed=
			{6,2,7,3};
//				{1,2,3};
		int[] is = code_1720.decode(encodeed, first);
		for (int i : is) {
			System.out.print(i +" ");
		}
	}
	
	public int [] decode(int [] encodeed,int first) {
		int len = encodeed.length + 1;
		int [] arr = new int[len];
		
		arr[0] = first;
		for (int i = 1; i < len; i++) {
			arr[i] = arr[i-1] ^ encodeed[i-1];
		}
		return arr;
	}
}
