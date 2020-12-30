package org.psring.leetcode.practive.y2020Dec;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9 
输入: N = 332
输出: 299
 * @author Sailor-why
 *
 */
public class LeetCode_746 {
 
	public static void main(String[] args) {
//		int arg=1234;
//		System.out.println(doingThing(arg));
//		
//		System.out.println(8+(12+5)/2);
//		System.out.println(8+((12+5)>>1));
		int [] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(new LeetCode_746().minCostClimbingStairs1(arr));
		
	}
	
	 public int minCostClimbingStairs1(int[] cost) {
	        int len = cost.length;
	        if(len<2 || len >1000){
	            return  0;
	        }
	        int f1 = 0;
	        int f2 = 0;
	        for(int i = 0; i < len; i ++){
	            int cur = cost[i] + Math.min(f1, f2);
	            f1 = f2;
	            f2 = cur;
	        }
	        return Math.min(f1,f2);
	 }
	/**
	 * 创建hashMap  保存 key(a,b)和Value(dog,cat)
	 *  
	 * @author {Sailor-why}
	 */
	private static int doingThing(int n) {
		// 结果
		int res = 0;
		// 位数  个，十、百、千、万
		int exp = 1;
		// 当前最大
		int p = 10;
		while (n >0) {
			// 按照个，十、百、千、万 位数开始判断
			int t = n % 10;
			if(t <= p) {
				res += t * exp;
				// 覆盖最大数
				p = t;
			}else {
				// 如果 大于最大数 取乘以10减一   最大值还要减一
				res = t*exp -1;
				p = t-1;
			}
			// n 切换位数
			n/=10;
			exp*=10;
		}
		return res;
	}
	
	
}
