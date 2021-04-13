package org.psring.leetcode.practive.y2021Apr;

import java.util.ArrayList;
import java.util.List;

import org.psring.leetcode.practive.util.TreeNode;
/**
 * desc 查找二叉树中最小的距离  返回  树中任意两不同节点值之间的最小差值
 * @author Sailor-why
 */
public class LeetCode_783 {

	public static void main(String[] args) {
		Integer[] arr =
//			{ 4, 2, 6, 1, 3 };
			{1,0,48,null,null,12,49};
		TreeNode node = new TreeNode().createBinaryTreeByArray(arr, 0);
		int inBST = new LeetCode_783().minDifInBST(node);
		System.out.println(inBST);
		new ZHONGXUBIANLI().inorderTraversal(node);
		
		
	}
	
	int pre;// 上一距离
	int ans;// 结果

	public int minDifInBST(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return ans;
	}

	private void dfs(TreeNode root) {
		// TODO 
		if(root == null) {
			return;
		}
		dfs(root.left);
		if(pre == -1) {
			pre = root.val;
		}else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		dfs(root.right);
	}
	
}

/**
 * desc 二叉树 中序遍历
 * 
 * @author Sailor-why
 */
class ZHONGXUBIANLI {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		// 递归遍历
		inorder(root, result);
		for (Integer integer : result) {
			System.out.print("  " + integer);
		}
		return result;
	}

	private void inorder(TreeNode root, List<Integer> result) {
		// TODO
		if (root == null) {
			return;
		}
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
	}

}
