package org.psring.leetcode.practive.y2021Jan;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.psring.leetcode.practive.util.UnionFind;

/**
 * desc 最小体力消耗路径
 * @author Sailor-why
 */
public class LeetCode_1631 {
	public static void main(String[] args) {
		int[][] arr =
//				{{1,2,2},{3,8,2},{5,3,5}};
				{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		int minimumEffortPath = new LeetCode_1631().minimumEffortPath(arr );
		System.out.println(minimumEffortPath);
	}
	
	int minimumEffortPath(int [][] height) {
		int ans = 0;
		int m = height.length;
		int n = height[0].length;
		List<int[]> edges = new ArrayList<int[]>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int id = i * n +j;
				if(i>0) {
					edges.add(new int[] {id-n,id,Math.abs(height[i][j] - height[i-1][j])});
				}
				if(j > 0) {
					edges.add(new int[] {id-1,id,Math.abs(height[i][j] - height[i][j-1])});
				}
			}
		}
		Collections.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		UnionFind uf = new UnionFind(m*n);
		for (int[] is : edges) {
			int x = is[0],y = is[1],v = is[2];
			uf.unite(x, y);
			if(uf.connected(0, m*n -1)) {
				ans = v;
				break;
			}
		}
		return ans;
	}
}
