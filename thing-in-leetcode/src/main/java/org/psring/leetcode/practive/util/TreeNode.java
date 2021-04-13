package org.psring.leetcode.practive.util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public int[] nums;
	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	public  TreeNode createTreeNode(int [] arr) {
		nums = arr;
        return helper(0,nums.length-1);
	}
	
	private TreeNode helper(int begin,int end){
        if(begin > end) return null;
        TreeNode root = new  TreeNode(nums[(begin+end)/2]);
        root.left = helper(begin,(begin+end)/2-1);
        root.right = helper((begin+end)/2+1,end);
        return root;
    } 
}