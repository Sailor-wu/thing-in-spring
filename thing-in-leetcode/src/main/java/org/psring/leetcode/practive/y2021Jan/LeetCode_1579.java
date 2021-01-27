package org.psring.leetcode.practive.y2021Jan;

import org.psring.leetcode.practive.util.UnionFind;

/**
 * desc 保证图可完全遍历
 * @author Sailor-why
 */
public class LeetCode_1579 {

	public static void main(String[] args) {
		int[][] edges= 
				{{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
//			{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
		int n = 4;
		int i = new LeetCode_1579().maxNumEdgesToRemove(n, edges);
		System.out.println("==="+i);
	}
	public int maxNumEdgesToRemove(int n,int [][] edges) {
		int ans = 0;
		UnionFind ufa = new UnionFind(n);
		UnionFind ufb = new UnionFind(n);
		// 节点编号从0开始
		for (int[] is : edges) {
			--is[1];
			--is[2];
		}
		
		// 公共边
		for (int[] is : edges) {
			if(is[0]==3) {
				if(!ufa.unite(is[1], is[2])) {
					++ans;
				}else {
					ufb.unite(is[1], is[2]);
				}
			}
		}
		// 独占边
		for (int[] is : edges) {
			if(is[0] == 1) {
				// a 独占
				if(!ufa.unite(is[1], is[2])) {
					++ans;
				}
			}else if(is[0] == 2) {
				// b 独占
				if(!ufb.unite(is[1], is[2])) {
					++ans;
				}
			}
		}
		if(ufa.setCount != 1 || ufa.setCount != 1) {
			return -1;
		}
		return ans;
	}
}
