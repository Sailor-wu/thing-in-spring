package org.psring.leetcode.practive.y2021Jan;

import java.util.Stack;

/**
 * desc 简化路径<br>
 *  以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。<br>
	在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） <br>
	表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。<br>
	更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径<br>
	请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。<br>
	最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。<br>
 * @author Sailor-why
 */
public class LeetCode_71 {

	public static void main(String[] args) {
		String path =
//					"/home//foo/";
//				"/a/./b/../../c/";
				"/a//b////c/d//././/..";
		String string = new LeetCode_71().simplifyPath(path );
		System.out.printf("简化后的路径是： %s  ",string);
	}
	
	public  String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		// 以 / 分割 成数组
		String [] str = path.split("/");
		for (int i = 0; i < str.length; i++) {
			// 去除每个字符的两边空格
			String cur = str[i].trim();
			if(cur == null || cur.length() ==0 || cur.equals(".")) {
				continue;
			}
			if(cur.equals("..")) {
				//
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push(cur);
			}
		}
		String ans = "";
		while (!stack.isEmpty()) {
			ans = "/"+stack.pop()+ans;
		}
		return ans;
	}
	
	
}
