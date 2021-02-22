package org.psring.leetcode.practive.y2021Feb;
/**
 * desc 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。 
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true 
 * 解释： 在上述矩阵中, 其对角线为:  
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
 * 各条对角线上的所有元素均相同, 因此答案是 True 。 
 * @author Sailor-why
 */
public class LeetCode_766 {
	public static void main(String[] args) {
		int [][] ma = 
			{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		
	}
	// 判断左上角
    public boolean isToeplitzMatrix(int[][] matrix) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        for (int i = 1; i < xLength; i++) {
            for (int j = 1; j < yLength; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    // 判断右下角
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        for (int i = 0; i < xLength - 1; i++) {
            for (int j = 0; j < yLength - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    } 
}
