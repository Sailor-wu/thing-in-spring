package org.psring.leetcode.practive.util;


public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;
	public Integer[] nums;
	public TreeNode() {
	}

	public TreeNode(Integer val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	public  TreeNode createTreeNode(Integer [] arr) {
		nums = arr;
        return helper(0,nums.length-1);
	}
	
	private TreeNode helper(int begin,int end){
        if(begin > end) return null;
        TreeNode root = new  TreeNode(null==(nums[(begin+end)/2])?0:nums[(begin+end)/2]);
        root.left = helper(begin,(begin+end)/2-1);
        root.right = helper((begin+end)/2+1,end);
        return root;
    } 
	/**
	 * 	前序遍历
	 * @param array
	 * @param index
	 * @return
	 * TreeNode
	 */
	public TreeNode createBinaryTreeByArray(Integer []array,int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

	public static void printNodePreOrder(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		printNodePreOrder(treeNode.left);
		System.out.print(treeNode.val+"\t");
		printNodePreOrder(treeNode.right);
	}

	public static void printNodePostOrder(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		System.out.print(treeNode.val+"\t");
		printNodePreOrder(treeNode.left);
		printNodePreOrder(treeNode.right);
	}

	public static void printNodeInOrder(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		printNodePreOrder(treeNode.right);
		printNodePreOrder(treeNode.left);
		System.out.print(treeNode.val+"\t");
	} 
}