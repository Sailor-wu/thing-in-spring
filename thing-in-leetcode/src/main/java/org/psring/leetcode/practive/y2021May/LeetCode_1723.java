package org.psring.leetcode.practive.y2021May;

import java.util.Arrays;

/**
 * desc 完成所有工作的最短时间   
 * <p>根据一个job数组和K个人
 * @author Sailor-why
 */
public class LeetCode_1723 {

	public static void main(String[] args) {
		
	}
	
	
	int K;
	int min = Integer.MAX_VALUE;
	
	public int minimumTimeRequired(int [] jobs,int k) {
		Arrays.sort(jobs); // 排序
		
		K = k;
		
		int time [] = new int[K];
		
		dfs(jobs.length -1 , jobs,time,0);
		
		return min;
	}

	private void dfs(int index, int[] jobs, int[] time0, int max) {
		// TODO 
		if(max >= min) 
			return;
		if(index == -1) {
			min = max;
			return;
		}
		int time [] = Arrays.copyOf(time0, K);
		Arrays.sort(time);
		
		for (int i = 0,pre = -1; i <= K -1; ++i) {
			if(time[i] != pre) {
				pre = time[i];
				time[i] += jobs[index];
				dfs(index-1, jobs, time, Math.max(max, time[i]));
				time[i] -= jobs[index];
			}
		}
	}
	
}
