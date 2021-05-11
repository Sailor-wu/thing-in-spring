package org.psring.leetcode.practive.y2021May;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * desc 用队列实现栈
 * @author Sailor-why
 */
public class LeetCode_225 {

	public static void main(String[] args) {
		
	}
	
}

/**
 * desc 用队列 实现 先进后出的栈
 * @author Sailor-why
 */
class MyStackImplWidthQueue{
	Queue<Integer> queue;
	public MyStackImplWidthQueue() {
		queue = new LinkedList<Integer>();
	}
	// 放元素
	public void push(int x) {
		int size = queue.size();
		queue.offer(x);// 添加到尾部
		// 翻转列表
		for (int i = 0; i < size; i++) {
			queue.offer(queue.poll());
		}
	}
	// 取元数
	public int pop() {
		return queue.poll();
	}
	
	public int top() {
		return queue.peek();
	}
	public boolean empty() {
		return queue.isEmpty();
	}
	
}

class MyStack{
	
	Stack<Integer> stack = new Stack<Integer>();
	/** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	stack.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(!stack.isEmpty()) {
    		return stack.pop();
    	}
    	return -1;
    }
    
    /** Get the top element. */
    public int top() {
    	return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return stack.isEmpty();
    }
}