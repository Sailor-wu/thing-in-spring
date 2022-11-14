package org.psring.leetcode.practive.y2020Dec;

import java.util.concurrent.ThreadLocalRandom;


/**
 * .回溯算法
 * @author Sailor-why
 *
 */
public class BacktrackingAlgorithm {

	// 全局变量
	private int min_dist = Integer.MAX_VALUE;
	public static void main(String[] args) {


//		int row = 6;
//		int[][] arr = new int[row][row];
//		for(int i = 0; i < row ; i++){
//			for (int j = 0; j < row; j++) {
//				arr[i][j] = ThreadLocalRandom.current().nextInt(0,10);
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		
		// 调用方式：minDistBacktracing(0, 0, 0, w, n);
//		BacktrackingAlgorithm backtrackingAlgorithm = new BacktrackingAlgorithm();
//		backtrackingAlgorithm.minDistBacktracing(0, 0, 0, arr, row);
//		System.out.println(backtrackingAlgorithm.getMinDist());
//		System.out.println("===============================");
//		int dp = backtrackingAlgorithm.minDistBacktracingDP( arr, row);
		
//		System.out.printf("最短路径的值是 %d ",dp);
		System.out.printf(String.valueOf(Integer.valueOf("null")));
	}
	
	/**
	 * .动态规划
	 * @author {Sailor-why}
	 */
	private int minDistBacktracingDP(int[][] arr, int row) {
		// 记录状态集合
		int  status [][] = new int[row][row];
		// 总和值
		int sums = 0;
		
		// 初始化状态数组 第一行
		for (int i = 0; i < row; i++) {
			sums += arr[i][0];
			status[i][0] = sums;
		}
		sums = 0;
		// 初始化状态数组 第一列
		for (int i = 0; i < row; i++) {
			sums += arr[0][i];
			status[0][i] = sums;
		}
//		for(int i = 0; i < row ; i++){
//			for (int j = 0; j < row; j++) {
//				System.out.print(status[i][j]+"\t");
//			}
//			System.out.println();
//		}
		for (int i = 1; i < row; ++i) {
			for (int j = 1; j < row; ++j) {
				// 往下走还是往右走
				status[i][j] =arr[i][j]+ Math.min(status[i-1][j], status[i][j-1]);
				System.out.print("-->"+status[i][j]);
			}
		}
		System.out.println("111111111111111111111111");
		for(int i = 0; i < row ; i++){
			for (int j = 0; j < row; j++) {
				System.out.print(status[i][j]+"\t");
			}
			System.out.println();
		}
		return status[row-1][row-1];
	}

	private int getMinDist() {
		// TODO Auto-generated method stub
		return min_dist;
	}

	/**
	 * .回溯算法
	 * @author {Sailor-why}
	 */
	public  void minDistBacktracing(int i,int j,int dist,int [][] w,int n) {
		if(i ==n && j == n) {
			// 取短
			if(dist < min_dist)
				min_dist = dist;
			return;
		}
		// 往下走
		if(i<n)
			minDistBacktracing(i+1, j, dist, w, n);
		// 往右走
		if(j<n)
			minDistBacktracing(i, j+1, dist, w, n);
	}
	
}
