package org.psring.leetcode.practive.y2021Mar;
/**
 * desc 螺旋矩阵遍历
 * 模拟
可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，
当路径超出界限或者进入之前访问过的位置时，顺时针旋转，进入下一个方向。
判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的
辅助矩阵 \textit{visited}visited，其中的每个元素表示该位置是否被访问过。
当一个元素被访问时，将 \textit{visited}visited 中的对应位置的元素设为已访问。
如何判断路径是否结束？由于矩阵中的每个元素都被访问一次，因此路径的长度即为矩阵中的元素数量，
当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
 * @author Sailor-why
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode_54 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> spiralOrder = new LeetCode_54().spiralOrder(matrix);
		for (Integer integer : spiralOrder) {
			System.out.print(integer + " ");
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> order = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return order;
		}
		// 行 列
		int rows = matrix.length, columns = matrix[0].length;
		// 是否访问标识
		boolean[][] visited = new boolean[rows][columns];
		// 总次数
		int total = rows * columns;
		// 开始 行 列
		int row = 0, colmun = 0;
		// 右 下 左 上
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int directionIndex = 0;
		for (int i = 0; i < total; i++) {
			// 添加,标记已访问
			order.add(matrix[row][colmun]);
			visited[row][colmun] = true;
			int nextRow = row + directions[directionIndex][0], nextColmun = colmun + directions[directionIndex][1];
			if (nextRow < 0 || nextRow >= rows || nextColmun < 0 || nextColmun >= columns
					|| visited[nextRow][nextColmun]) {
				// 需要换方向
				directionIndex = (directionIndex + 1) % 4;
			}
			row += directions[directionIndex][0];
			colmun += directions[directionIndex][1];
		}
		return order;
	}
}
