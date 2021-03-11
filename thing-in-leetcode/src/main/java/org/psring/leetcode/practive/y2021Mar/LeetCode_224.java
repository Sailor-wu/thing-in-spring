package org.psring.leetcode.practive.y2021Mar;

import java.util.Deque;
import java.util.LinkedList;

/**
 * desc 实现基本的计算器
 * @author Sailor-why
 */
public class LeetCode_224 {

	public static void main(String[] args) {
		String s=
				"(1+(4+5+2)-3)+(6+8)";
		int calculate = new LeetCode_224().calculate(s);
		System.out.println(calculate);
	}

	private int calculate(String s) {
		Deque<Integer> ops = new LinkedList<Integer>();
		ops.push(1);
		int sign = 1,ret = 0,i = 0;
		int n = s.length();
		while (i < n) {
			if(s.charAt(i) == ' ') {
				i++;
			}else if(s.charAt(i)=='+') {
				sign = ops.peek();
				i++;
			}else if(s.charAt(i)=='-') {
				sign = -ops.peek();
			}else if(s.charAt(i)=='(') {
				ops.push(sign);
				i++;
			}else if(s.charAt(i)==')') {
				ops.pop();
				i++;
			}else {
				long num = 0;
				while (i<n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) -'0';
					i++;
				}
				ret += sign * num;
			}
		}
		return ret;
	}
}
