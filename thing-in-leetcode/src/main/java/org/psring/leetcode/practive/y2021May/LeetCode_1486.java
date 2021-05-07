package org.psring.leetcode.practive.y2021May;
/**
 * desc 数组异或操作
 * @author Sailor-why
 */
public class LeetCode_1486 {

	public static void main(String[] args) {
		LeetCode_1486 code_1486 = new LeetCode_1486();
		int n =
//				5;
				4;
		int start =
//				0;
				3;
		System.out.println(code_1486.xorOperation(n , start));
		System.out.println(code_1486.xorOperationWhithMath(n , start));
	}
	
	public int xorOperation(int n, int start) {
		int result = start , i;
		for (i = 1; i < n; i++) {
			result = result ^ (start + i *2);
			
		}
		return result;
    }
	
	
	public int xorOperationWhithMath(int n,int start) {
		int s = start >>1,e = n & start & 1;
		int ret = sumXor(s -1) ^ sumXor(s + n -1);
		return ret << 1 | e;
		
	}

	private int sumXor(int i) {
		if( i % 4 == 0) {
			return i;
		}
		if( i % 4 == 1) {
			return 1;
		}
		if( i % 4 == 2) {
			return i + 1;
		}
		return 0;
	}
	
}
