package org.psring.leetcode.practive.y2021Feb;
/**
 * 思路和算法 
 * 尺寸为 R x C 的矩阵 A 转置后会得到尺寸为 C x R 的矩阵 ans，对此有 ans[c][r] = A[r][c]。
 * 让我们初始化一个新的矩阵 ans 来表示答案。然后，我们将酌情复制矩阵的每个条目。 
 * @author Sailor-why
 */
public class LeetCode_867 {

	public static void main(String[] args) {
		int[][] A=
				{{1,2,3},{4,5,6},{7,8,9}};
		int[][] transpose = new LeetCode_867().transpose(A);
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				System.out.print(transpose[i][j]);
			}
			System.out.println();
		}
	}
	
	public int[][] transpose(int[][] A) {
		int L = A.length,R = A[0].length;
		int [][] ans = new int[R][L];
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < R; j++) {
				ans[j][i] = A[i][j];
			}
		}
		return ans;
	}
}
