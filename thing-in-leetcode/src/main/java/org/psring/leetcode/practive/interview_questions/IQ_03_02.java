package org.psring.leetcode.practive.interview_questions;

import java.util.Stack;

/**
 * desc 最小栈
 * @author Sailor-why
 */
public class IQ_03_02 {

	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
//		System.out.println(minStack.getMin());   //--> 返回 -3.
//		minStack.pop();
//		System.out.println(minStack.top());     // --> 返回 0.
//		minStack.push(4);
//		minStack.push(-5);
//		System.out.println(minStack.top());
//		System.out.println(minStack.getMin());  // --> 返回 -2.
		System.out.println(minStack.top());     // --> 返回 0.
		minStack.pop();
		System.out.println(minStack.top());     // --> 返回 0.
		minStack.pop();
		System.out.println(minStack.top());     // --> 返回 0.
		minStack.pop();
	}
	
}

/**
 * desc 最小栈
 * @author Sailor-why
 */
class MinStack{
	
	// 创建节点保存当前的栈值和当前最小值
	static class Item{
		private int val;
		private int curMin;
	}
	public MinStack() {	}
	
	// 创建栈集合
	private Stack<Item> stack = new Stack<MinStack.Item>();
	// 记录当前最小的值  给 Integer.MAX_VALUE
	private int min = Integer.MAX_VALUE;

	// 入栈
	public void push(int x) {
		Item item = new Item();
		item.val = x;
		if(x < min)
			min = x;
		
		item.curMin = min;
		stack.push(item);
	}
	
	// 出栈
	public void pop() {
		stack.pop();
		// 判断是否最后一个元素
		if(stack.isEmpty()) {
			min = Integer.MAX_VALUE;
		}else {
			min = stack.peek().curMin;
		}
	}
	
	// 查看值
	public int top() {
		return stack.peek().val;
	}
	
	public int getMin() {
		return min;
	}
}

