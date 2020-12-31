package org.psring.leetcode.practive.y2020Dec;

import java.util.Arrays;

/**
 * desc 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
   	<p>示例 1:
	<p>输入: [ [1,2], [2,3], [3,4], [1,3] ]
	<p>输出: 1
	<p>解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * @author Sailor-why
 */
public class LeetCode_435 {

	public static void main(String[] args) {
		int [][] arr =  {{1,3}, {2,3}, {3,4}, {1,3} }; //{{1,2}, {1,2}, {1,2}};
		
		int intervals = new LeetCode_435().eraseOverlapIntervals(arr);
		System.out.println(intervals);
	}
	/**
	 * <p>选择结尾最短的，后面才可能连接更多的区间
	 * <p>（如果两个区间有重叠，应该保留结尾小的） 把问题转化为最多能保留多少个区间，使他们互不重复，
	 * <p>则按照终点排序，每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
	 * int
	 */
	public int eraseOverlapIntervals(int [][] arr) {
		if(arr.length < 2) {
			return 0;
		}
		// 按 end 升序排序
		Arrays.sort(arr,(o1,o2) ->{
			return o1[1]-o2[1];
		});
		// 至少有一个区间不相交
		int preRight = Integer.MIN_VALUE,count = 0;
		for (int i = 0; i < arr.length; ++i) {
			if(arr[i][0] < preRight) {
				++count;
			}else {
				preRight = arr[i][1];
			}
		}
		return count;
	}
}
