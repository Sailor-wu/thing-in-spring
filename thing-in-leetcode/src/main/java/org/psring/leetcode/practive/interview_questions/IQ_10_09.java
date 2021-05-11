package org.psring.leetcode.practive.interview_questions;
/**
 * desc 排序矩阵查找
 * @author Sailor-why
 * 	给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
	示例:
	现有矩阵 matrix 如下：
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	给定 target = 5，返回 true。
	给定 target = 20，返回 false。

 */
public class IQ_10_09 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		// 从右上角开始
		int col = matrix[0].length-1;
		int row = 0;
		while (col >= 0 && row <= matrix.length -1) {
			if(target == matrix[row][col]) {
				return true;
			}else if (target < matrix[row][col]) {
				// 如果查找的值大 下一步往左找
				col--;
			}else if (target > matrix[row][col]) {
				// 如果查找的值小 下一步往下找
				row++;
			}
			
		}
		return false;
	}
	
	/**
	 * desc 暴力循环
	 * @param matrix
	 * @param target
	 * @return
	 * boolean
	 */
	public boolean searchMatrix1(int[][] matrix, int target) {

        for (int[] is : matrix) {
			if(target > is[0]) {
				return false;
			}
        	for (int  is2 : is) {
        		if(target == is2)
        			return true;
			}
        	
		}
        System.out.println();
        return false;
    }
}
