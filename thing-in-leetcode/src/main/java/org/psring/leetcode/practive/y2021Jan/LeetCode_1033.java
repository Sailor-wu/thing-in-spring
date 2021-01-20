package org.psring.leetcode.practive.y2021Jan;

import java.util.Arrays;

/**
 * desc移动石子直到连续
 *	 示例 1：
	输入：a = 1, b = 2, c = 5
	输出：[1, 2]
	解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
	示例 2：
	
	输入：a = 4, b = 3, c = 2
	输出：[0, 0]
	解释：我们无法进行任何移动。
	
	提示：
	1 <= a <= 100
	1 <= b <= 100
	1 <= c <= 100
	a != b, b != c, c != a 
 * @author Sailor-why
 */
public class LeetCode_1033 {

	public static void main(String[] args) {
		
//		int a= 5,b =3 ,c = 6;
		int a= 1,b =2 ,c = 5;
		int[] stones = new LeetCode_1033().numMovesStones(a, b, c);
		System.out.println(Arrays.toString(stones));
	}
	/**
	 * @param a 5
	 * @param b 3
	 * @param c 6
	 * @return
	 * int[]
	 */
	public int [] numMovesStones(int a,int b,int c) {
		int t;
		// a 大于 b   a = 3  b = 5
		if(a>b) {
			t = a;
			a = b;
			b = t;
		}
		// a = 3  c = 6
		if(a>c) {
			t = a;
			a = c;
			c = t;
		}
		// b = 5  c = 6
		if(b>c) {
			t = b;
			b = c;
			c = t;
		}
		// a，b，c相邻无法移动
		if(a==b-1 && a == c-2) {
			return new int []{0,0};
		}
		// 有两个数相邻或相近（隔一位）注意我们上面已经排除了3个数相邻情况
		if(b == a+1 || c == a+2 || b == c-2) {
			return new int[] {1,c-a-2};
		}
		return new int[] {2,c-a-2};
	}
	
	
}
