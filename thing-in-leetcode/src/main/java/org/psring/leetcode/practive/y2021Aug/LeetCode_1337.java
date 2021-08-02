package org.psring.leetcode.practive.y2021Aug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * desc 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * .请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 如果第 i 行的军人数量少于第 j 行
 * .或者两行军人数量相同但 i 小于
 * j，那么我们认为第 i 行的战斗力比第 j 行弱。 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * 
 * @author Sailor-why
 */
public class LeetCode_1337 {

	public static void main(String[] args) {
		
		LeetCode_1337 code_1337 = new LeetCode_1337();
		int [][] arr = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		int k = 3;
		int[] rows = code_1337.kWeakestRows(arr, k);
		for (int i : rows) {
			System.out.println(i);
		}
		
	}
	
	public int[] kWeakestRows(int[][] mat, int k) {
		int m = mat.length,h = mat[0].length;
		List<int[]> power = new ArrayList<int []>();
		// 遍历矩阵行 ，获取军人的位置
		for (int i = 0; i < m; i++) {
			// 二分查找 左边0 右边的行的长度-1  巨人位置pos -1
			int l = 0,r = h-1 ,pos = -1;
			// 小于等于
			while(l <= r) {
				// 防止极端情况下的整形溢出，使用下面的逻辑求出mid
		        int mid = l + (r-l)/2;
		        if(mat[i][mid] == 0) {
		        	// 平民 往左
		        	r = mid -1;
		        }else {
		        	// 军人 记录军人位置 往右 
		        	pos = mid;
		        	l = mid + 1;
		        }
			}
			// 保存当前行的强弱度
			power.add(new int[] {pos + 1 , i});
		}
		
		// 排序 
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) {
					// 军人强弱排序
					return o1[0] - o2[0];
				}else {
					// 索引排序
					return o1[1] - o2[1];
				}
			}
		});
		for (int[] is : power) {
			pq.offer(is);
		}
		// 取排名  k 
		int ans[] = new int [k];
		for (int i = 0; i < k; i++) {
			// 取行索引
			ans[i] = pq.poll()[1];
		}
		return ans;
	}
}
