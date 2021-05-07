package org.psring.leetcode.practive.interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.psring.leetcode.practive.util.TreeNode;

/**
 * desc 给定二叉树 和指定的值，打印该二叉树中路径和等于 指定值的路径，并返回
 * 
 * @author Sailor-why
 */
public class IQ_16_34 {

	public static void main(String[] args) {

	}

	private List<List<Integer>> retList = new ArrayList<List<Integer>>();
	private LinkedList<Integer> list = new LinkedList<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, target);
		return retList;
	}

	// 前序遍历
	private void dfs(TreeNode root, int target) {
		if (root != null) {
			list.add(root.val);
			target -= root.val;
			
			if (target ==0 && root.left == null && root.right == null) {
				retList.add(new LinkedList<Integer>(list));
			}
			dfs(root.left, target);
			dfs(root.right, target);
			list.removeLast();
		}

	}


}
