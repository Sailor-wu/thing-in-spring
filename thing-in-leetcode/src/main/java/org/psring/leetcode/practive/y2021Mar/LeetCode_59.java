package org.psring.leetcode.practive.y2021Mar;
/**
 * desc 螺旋矩阵 II 
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3 
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * @author Sailor-why
 */
public class LeetCode_59 {

	public static void main(String[] args) {
		int n = 4;
		int[][] generateMatrix = new LeetCode_59().generateMatrix(n);
		for (int[] is : generateMatrix) {
			for (int i = 0; i < is.length; i++) {
				System.out.print("-"+is[i]);
			}
			System.out.println();
		}
	}
	
	public int[][] generateMatrix(int n) {
		int [][] matrix = new int[n][n];
		// 行 列
		int rows = n,columns = n; 
		int left = 0,right = columns -1,top = 0, bottom = rows -1,value=1;
		
		while (left <= right && top <= bottom) {
			// 右
			for (int column = left; column <= right; column++) {
				matrix[top][column] = value++;
			}
			// 右下
			for (int row = top+1; row <= bottom; row++) {
				matrix[row][right]= value++;
			}
			
			if(left < right && top < bottom) {
				for (int column = right - 1; column > left; column--) {
					 matrix[bottom][column]= value++;
				}
				for (int row = bottom; row > top; row--) {
					 matrix[row][left]= value++;
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return matrix;
	}
}
