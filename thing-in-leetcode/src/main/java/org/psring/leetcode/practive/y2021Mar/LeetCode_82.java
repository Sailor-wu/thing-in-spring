package org.psring.leetcode.practive.y2021Mar;

import org.psring.leetcode.practive.util.ListNode;

/**
 * desc 删除链表中的重复的元素 ，只保留一个
 * @author Sailor-why
 */
public class LeetCode_82 {

	public static void main(String[] args) {
		int arr [] = {};
//			{1,1,2};
		ListNode head = ListNode.createNode(arr);
		ListNode duplicates = new LeetCode_82().deleteDuplicates(head);
		while (duplicates != null) {
			System.out.println(duplicates.val);
			duplicates=duplicates.next;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head ==null || head.next == null) {
			return head;
		}
		
		head.next = deleteDuplicates(head.next);
		if(head.val == head.next.val) {
			head = head.next;
		}
		
		return head;
	}
}
