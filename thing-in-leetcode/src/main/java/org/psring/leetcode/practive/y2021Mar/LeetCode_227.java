package org.psring.leetcode.practive.y2021Mar;

import java.util.Deque;
import java.util.LinkedList;

/**
 * desc 实现基本的计算器(+  - * / )
 * @author Sailor-why
 */
public class LeetCode_227 {

	public static void main(String[] args) {
		String s=
//				"(1+(4+5+2)-3)+(6+8)";
//				"3+2*2";
				"3+5 / 2 ";
		int calculate = new LeetCode_227().calculate(s);
		System.out.println(calculate);
	}

	private int calculate(String s) {
		int ans = 0, num = 0, n = s.length();
		Deque<Integer> stack = new LinkedList<Integer>();
		char preSign = '+';
		for (int i = 0; i < n; i++) {
			if(Character.isDigit(s.charAt(i))) {
				num = num *10 +s.charAt(i) - '0';
			}
			if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!= ' ' 
					|| i == n-1) {
				switch (preSign) {
				case '+':
					stack.push(num);
					break;
				case '-':
					stack.push(-num);
					break;
				case '*':
					stack.push(stack.pop() * num);
					break;
				case '/':
					stack.push(stack.pop() / num);
					break;
				}
				preSign = s.charAt(i);
				num = 0;
			}
		}
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}
}
