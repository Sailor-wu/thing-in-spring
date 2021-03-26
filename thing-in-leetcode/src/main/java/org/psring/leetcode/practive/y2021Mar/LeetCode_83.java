package org.psring.leetcode.practive.y2021Mar;

import org.psring.leetcode.practive.util.ListNode;

/**
 * desc 删除链表中的重复的元素
 * @author Sailor-why
 */
public class LeetCode_83 {
	public static void main(String[] args) {
		int arr [] = 
//			{};
			{1,1,2};
		ListNode head = ListNode.createNode(arr);
		ListNode duplicates = new LeetCode_83().deleteDuplicates(head);
		while (duplicates != null) {
			System.out.println(duplicates.val);
			duplicates=duplicates.next;
		}
	}

	private ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		// 如果当前节点等于下一个节点
		if(head.val == head.next.val) {
			// 继续循环判断  下一个节点是否为空并且是否等于下一个节点 做替换操作
			while (head.next != null && head.val == head.next.val) {				
				head.next = head.next.next;
			}
			// 最后要把当前节点也置空
			head = deleteDuplicates(head.next);
		}else {			
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}
}
