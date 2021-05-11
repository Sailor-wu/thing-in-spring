package org.psring.leetcode.practive.y2021May;

import java.util.LinkedList;
import java.util.List;

import org.psring.leetcode.practive.util.TreeNode;

public class LeetCode_872 {

	
	public static void main(String[] args) {
//		Queue<String> queue = new ArrayDeque<String>();
//		queue.add("1");
//		queue.add("4");
//		queue.add("3");
//		 
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
		
//		List<String> link = new LinkedList<String>();
//		link.add("0");
//		link.add("9");
//		link.add("4");
//		link.add("3");
//		
//		for (String string : link) {
//			System.out.println(string);
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 64530; i++) {
			sb.append(i+"");
		}
		System.out.println(sb.toString());
	}
	
	List<Integer> link1 = new LinkedList<Integer>();
	List<Integer> link2 = new LinkedList<Integer>();
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		dfs(root1,1);
		dfs(root2,2);
		// equals 大法没有自己写 检查方法快  这是基于数值类型，在未知类型下，不能确保这个结果是正确的。
		
//		return link1.equals(link2);
		
		return check(link1,link2);
	}

	private void dfs(TreeNode root,int flg) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null && flg == 1) {
			link1.add(root.val);
		}
		if(root.left == null && root.right == null && flg == 2) {
			link2.add(root.val);
		}
		dfs(root.left, flg);
		dfs(root.right, flg);
		
	}

	private boolean check(List<Integer> link1,List<Integer> link2) {
		int l1 = link1.size();
		if(l1 != link2.size())
			return false;
		for (int i = 0; i < l1; i++) {
			if(link1.get(i) != link2.get(i))
				return false;
		}
		return true;
	}

}
