package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * desc <br/>
 * 公司共有 n 个项目和  m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。 <br/>
 * group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。<br/>
 * （项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。 <br/>
 * 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表： <br/>
 * 同一小组的项目，排序后在列表中彼此相邻。 <br/>
 * 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，<br/>
 * 其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。 <br/>
 * 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。 <br/> <br/>
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems =
 * [[],[6],[5],[6],[3,6],[],[],[]] <br/> <br/>
 * 输出：[6,3,4,1,5,2,0,7]
 * 
 * @author Sailor-why
 */
public class LeetCode_1203 {

	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

		int total = n + 2 * m;
		List<Integer>[] graph = new ArrayList[total];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {

			int grp = group[i];
			if (grp != -1) {
				int first = n + 2 * grp;
				int second = n + 2 * grp + 1;
				graph[first].add(i);
				graph[i].add(second);
			}
			List<Integer> befores = beforeItems.get(i);
			if (befores.size() == 0)
				continue;

			for (int before : befores) {

				int grp2 = group[before];

				if (grp == -1 && grp2 == -1)
					graph[before].add(i);

				else if (grp != -1 && grp2 == -1)
					graph[before].add(n + 2 * grp);

				else if (grp == -1 && grp2 != -1)
					graph[n + 2 * grp2 + 1].add(i);

				else if (grp != grp2)
					graph[n + 2 * grp2 + 1].add(n + 2 * grp);

				else
					graph[before].add(i);

			}
		}

		boolean[] visited = new boolean[total];
		boolean[] inStack = new boolean[total];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = n; i < total; i++) {
			if (!visited[i]) {
				boolean ans = topolgicalSort(graph, i, visited, inStack, stack);
				if (!ans)
					return new int[0];
			}
		}

		for (int i = 0; i < n; i++) {
			if (!inStack[i])
				stack.add(i);
		}

		int[] ans = new int[n];
		int index = 0;
		while (!stack.isEmpty()) {
			int num = stack.pop();
			if (num < n)
				ans[index++] = num;
		}

		return ans;
	}

	public boolean topolgicalSort(List<Integer>[] graph, int curr, boolean[] visited, boolean[] inStack,
			Stack<Integer> stack) {

		if (visited[curr] && !inStack[curr])
			return false;

		if (visited[curr])
			return true;

		visited[curr] = true;
		List<Integer> nbrs = graph[curr];
		for (int nbr : nbrs) {
			boolean flag = topolgicalSort(graph, nbr, visited, inStack, stack);
			if (!flag)
				return false;
		}

		stack.add(curr);
		inStack[curr] = true;

		return true;
	}
}
