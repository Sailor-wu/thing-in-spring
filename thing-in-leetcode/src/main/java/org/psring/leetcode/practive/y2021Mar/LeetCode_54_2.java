package org.psring.leetcode.practive.y2021Mar;
/**
 * desc 螺旋矩阵遍历
 * 按层模拟
可以将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层的元素。
定义矩阵的第 kk 层是到最近边界距离为 kk 的所有顶点。例如，下图矩阵最外层元素都是第 11 层，
次外层元素都是第 22 层，剩下的元素都是第 33 层。
[[1, 1, 1, 1, 1, 1, 1],
 [1, 2, 2, 2, 2, 2, 1],
 [1, 2, 3, 3, 3, 2, 1],
 [1, 2, 2, 2, 2, 2, 1],
 [1, 1, 1, 1, 1, 1, 1]]
对于每层，从左上方开始以顺时针的顺序遍历所有元素。
假设当前层的左上角位于 (\textit{top}, \textit{left})(top,left)，
右下角位于 (\textit{bottom}, \textit{right})(bottom,right)，按照如下顺序遍历当前层的元素。
从左到右遍历上侧元素，依次为 (\textit{top}, \textit{left})(top,left) 到 (\textit{top}, \textit{right})(top,right)。
从上到下遍历右侧元素，依次为 (\textit{top} + 1, \textit{right})(top+1,right) 到 (\textit{bottom}, 
\textit{right})(bottom,right)。
如果 \textit{left} < \textit{right}left<right 且 \textit{top} < \textit{bottom}top<bottom，
则从右到左遍历下侧元素，依次为 (\textit{bottom}, \textit{right} - 1)(bottom,right−1) 到 (\textit{bottom}, 
\textit{left} + 1)(bottom,left+1)，以及从下到上遍历左侧元素，依次为 (\textit{bottom}, 
\textit{left})(bottom,left) 到 (\textit{top} + 1, \textit{left})(top+1,left)。
遍历完当前层的元素之后，将 \textit{left}left 和 \textit{top}top 分别增加 11，将 \textit{right}right 
和 \textit{bottom}bottom 分别减少 11，进入下一层继续遍历，直到遍历完所有元素为止。
 * @author Sailor-why
 */

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_54_2 {

	public static void main(String[] args) {
		int[][] matrix=
				{{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> spiralOrder = new LeetCode_54_2().spiralOrder(matrix);
		for (Integer integer : spiralOrder) {
			System.out.print(integer +" ");
		}
	}
	// 1 2 3 6 9 8 7 4 5 
	public List<Integer> spiralOrder(int [][] matrix){
		List<Integer> order = new LinkedList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return order;
		}
		// 行 列
		int rows = matrix.length,columns = matrix[0].length; 
		int left = 0,right = columns -1,top = 0, bottom = rows -1;
		while (left <= right && top <= bottom) {
			// 右
			for (int column = left; column <= right; column++) {
				order.add(matrix[top][column]);
			}
			// 右下
			for (int row = top+1; row <= bottom; row++) {
				order.add(matrix[row][right]);
			}
			
			if(left < right && top < bottom) {
				for (int column = right - 1; column > left; column--) {
					order.add(matrix[bottom][column]);
				}
				for (int row = bottom; row > top; row--) {
					order.add(matrix[row][left]);
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return order;
	}
}