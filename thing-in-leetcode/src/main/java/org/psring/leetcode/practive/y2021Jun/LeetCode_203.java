package org.psring.leetcode.practive.y2021Jun;

import org.psring.leetcode.practive.util.ListNode;

/**
 * desc 移除链表元素
 * 
 * @author Sailor-why
 */
public class LeetCode_203 {
	
	public static void main(String[] args) {
		int[] arr= {
				1,2,6,3,4,5,6
		};
		ListNode head = ListNode.createNode(arr);
		ListNode node = LeetCode_203.removeElements(head, 6);
		ListNode.printNodeVal(node);
		
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode newNode = new ListNode(-1);
		newNode.next = head; // 新创建一份链表
		ListNode cur = newNode;// 操作引用
		while (null != cur.next) {
			if(val == cur.next.val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return newNode.next;
		
	}
}
