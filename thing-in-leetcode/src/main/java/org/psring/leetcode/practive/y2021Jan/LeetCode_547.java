package org.psring.leetcode.practive.y2021Jan;
/**
 * desc 省份数量 <br/> 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 	<br/>如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
	<br/>省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
	<br/>给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
	<br/>而 isConnected[i][j] = 0 表示二者不直接相连。
	<br/>返回矩阵中 省份 的数量。 
	<br/>
	<br/>输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
	<br/>输出：2
 * @author Sailor-why
 */
public class LeetCode_547 {

	public static void main(String[] args) {
		int [][] M =
				{{1,0,0},{0,1,0},{0,0,1}};
//			{{1,1,0},{1,1,0},{0,0,1}};
		int res = new LeetCode_547().findCircleNum(M);
		System.out.println("res :" + res);
	}

	/**
	 * <br/>思路：好友关系可以看成是一个无向图，例如第 0 个人与第 1 个人是好友，
	 * <br/>那么 M[0][1] 和 M[1][0] 的值都为 1，依次遍历这些同学，
	 * <br/>即遍历到某位同学，就给他打一个标记。使用一个hasVisited数组，
	 * <br/>依次判断每个节点，如果其未访问，朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点。
	 * @param m
	 * @return
	 * int
	 */
	public int findCircleNum(int[][] m) {
		/**
		 * 	使用一个是否访问的数组（visited），依次判断每个节点<br/>
		 * 	如果未访问，朋友圈数加1 并对该节点进行层次遍历搜索标记所有访问到的节点
		 */
		boolean [] visited = new boolean[m.length];
		int ret = 0;
		for (int i = 0; i < m.length; i++) {
			if(!visited[i]) {
				// 遍历
				dfs(m,visited,i);
				ret++;
			}
		}
		return ret;
	}
	/**
	 * 	深度优先搜索
	 * @param m
	 * @param visited
	 * @param i
	 * void
	 */
	private void dfs(int[][] m, boolean[] visited, int i) {
		for (int j = 0; j < m.length; j++) {
			//M[i][n]其实就等于M[n][i],当前第i同学还没有被访问（并且i!=n）
			if(m[i][j]==1 && !visited[j]) {
				//设置已访问标记
				visited[j] = true;
				dfs(m, visited, j);
			}
		}
	}
}
