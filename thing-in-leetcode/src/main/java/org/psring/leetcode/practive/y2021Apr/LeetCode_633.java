package org.psring.leetcode.practive.y2021Apr;

/**
 * desc 平方数之和
 * 
 * @author Sailor-why
 */
public class LeetCode_633 {

	public static void main(String[] args) {

		LeetCode_633 code_633 = new LeetCode_633();
		int c=
				4;
		System.out.println(code_633.judgeSquareSum(c));
		System.out.println(Math.sqrt(5));
	}

	public boolean judgeSquareSum(int c) {
		int i = 0 ,j = (int) Math.sqrt(c);
		while(i<=j) {
			int total = i*i+j*j;
			if(total > c)j--;
			else if(total < c)i++;
			else return true;
		}
		return false;
	}
}
