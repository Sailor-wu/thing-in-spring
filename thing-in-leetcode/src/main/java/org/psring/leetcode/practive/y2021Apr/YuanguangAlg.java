package org.psring.leetcode.practive.y2021Apr;

import java.util.ArrayList;
import java.util.List;

import org.psring.leetcode.practive.util.TreeNode;

public class YuanguangAlg {

	public static void main(String[] args) {
		Integer[] arr = 
//			{4,9,0,5,1};
			{1,2,3};
		TreeNode node = new TreeNode().createBinaryTreeByArray(arr , 0);
		int binaryTree = new YuanguangAlg().binaryTreePaths(node);
		System.out.println(binaryTree);
	}
	
	// 保存所有路径  123   12  13 
	List<String> sumStr = new ArrayList<String>();
	
	public int binaryTreePaths(TreeNode root) {
        constructPaths(root, "", sumStr);
        int sum = 0;
        for (String string : sumStr) {
			sum+= Integer.valueOf(string);
		}
        return sum;
    }

    public void constructPaths(TreeNode root, String path, List<String> sum) {
        if (root != null) {
            StringBuffer s = new StringBuffer(path);
            s.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            	sumStr.add(s.toString());
            } else {
                s.append("");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, s.toString(), sum);
                constructPaths(root.right, s.toString(), sum);
            }
        }
    } 
}
