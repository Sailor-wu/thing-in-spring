package org.psring.leetcode.practive.y2021Jan;

/**
 * desc给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。<br>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，<br>
 * 含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。<br>
 * 示例 1:<br>
 * 输入: <br>
 * m = 3, n = 3<br>
 * operations = [[2,2],[3,3]]<br>
 * 输出: 4<br>
 * 解释: <br>
 * 初始状态, M = <br>
 * [[0, 0, 0],<br>
 * [0, 0, 0],<br>
 * [0, 0, 0]]<br>
 * 执行完操作 [2,2] 后, M = <br>
 * [[1, 1, 0],<br>
 * [1, 1, 0],<br>
 * [0, 0, 0]]<br>
 * 执行完操作 [3,3] 后, M = <br>
 * [[2, 2, 1],<br>
 * [2, 2, 1],<br>
 * [1, 1, 1]]<br>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。<br>
 * <br><br>
 * 思路：<br>
 * 每次操作都是左上角区域从（0, 0）到（a, b）的矩形，必定重叠，所以找最小的a乘最小的b就行
 * @author Sailor-why
 */
public class LeetCode_598 {
 
	public static void main(String[] args) {
		int m =
				3;
		int n =
				3;
		int [][] ops = 
			{{2,2},{3,3}};
		
		int count = new LeetCode_598().maxCount(m, n, ops);
		System.out.println("maxCount :"+count);
	}

	public int maxCount(int m, int n, int[][] ops) {
		if(ops.length == 0) return m * n;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE; 
        for (int i = 0; i < ops.length; i++){
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a * b;
	}
}
