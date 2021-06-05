package org.psring.leetcode.practive.y2021May;

import org.psring.leetcode.practive.util.TreeNode;

/**
 * desc 判断输入的 x,y 是否是堂兄弟节点
 * @author Sailor-why
 */
public class LeetCode_993 {

	public static void main(String[] args) {
		LeetCode_993 code = new LeetCode_993();
		TreeNode node = new TreeNode();
		Integer[] arr =
//				{1,2,3,4};
			{1,2,3,null,4,null,5};
		TreeNode node2 = node.createBinaryTreeByArray(arr,0 );
		int y=
				4;
		int x=
				5;
		boolean b = code.isCousins(node2, x, y);
		System.out.println(b);
	}
	// -p 代表 父节点   -d 代表深度
	int xp,xd,yp,yd;
	
	public boolean isCousins(TreeNode root,int x,int y) {
		dfs(root.left,1,x,y,root.val);
		dfs(root.right,1,x,y,root.val);
		// 返回 父节点不同  深度相同的 x y 
		return (xp != yp) && (xd == yd);
	}

	private void dfs(TreeNode node, int d, int x, int y, Integer val) {
		// 节点为空
		if(node == null)
			return;
		if(node.val == x) {
			xp = val;
			xd = d;
		}else if(node.val == y) {
			yp = val;
			yd = d;
		}else {
			dfs(node.left,d+1,x,y,node.val);
			dfs(node.right,d+1,x,y,node.val);
		}
	}
	
}
