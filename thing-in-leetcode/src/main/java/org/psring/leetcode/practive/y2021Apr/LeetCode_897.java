package org.psring.leetcode.practive.y2021Apr;

import java.util.ArrayList;
import java.util.List;

import org.psring.leetcode.practive.util.TreeNode;

/**
 * desc 遍历二叉树
 * @author Sailor-why
 */
public class LeetCode_897 {

	public static void main(String[] args) {
		Integer[] array = 
				{5,3,6,2,4,null,8,1,null,null,null,7,9};
		TreeNode treeNode = new TreeNode().createBinaryTreeByArray(array, 0);
		System.out.println("前序遍历：");
		TreeNode.printNodePreOrder(treeNode);
//		System.out.println("\n后序遍历：");
//		TreeNode.printNodePostOrder(treeNode);
//		System.out.println("\n中序遍历：");
//		TreeNode.printNodeInOrder(treeNode);
		
		LeetCode_897 leetCode_897 = new LeetCode_897();
		leetCode_897.increasingBST1(treeNode);
		TreeNode.printNodePreOrder(leetCode_897.head);
		

		
		
		
		
		
		
	}
	
	TreeNode d = new TreeNode(-1);
	TreeNode head = d;
	/**
	 *   desc 中序遍历   左中右 
	 * @param root
	 * @return 返回一个只有右节点的树
	 * TreeNode
	 */
	public TreeNode increasingBST(TreeNode root) {
		if(root == null) return root;
		// 左
		increasingBST(root.left);
		// 接到 新树的右节点上
		d.right = root;
		root.left = null; // 左节点置空
		
		d = d.right;
		increasingBST(root.right);
		return head.right;
		
	}
	
	
	public TreeNode increasingBST1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		inOrder(root,res);
		TreeNode node = new TreeNode(-1);
		for (Integer integer : res) {
			node.right = new TreeNode(integer);
		}
		return node;
	}


	private void inOrder(TreeNode root, List<Integer> res) {
		if(root == null) return;
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}
	
}
