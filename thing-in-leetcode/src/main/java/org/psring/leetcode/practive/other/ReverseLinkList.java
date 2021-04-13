package org.psring.leetcode.practive.other;

import org.psring.leetcode.practive.util.ListNode;
/**
 * desc 链表反转 
 * @author Sailor-why
 */
public class ReverseLinkList {

	public ListNode reverse(ListNode head) {
	    if (head == null || head.next == null){
	        return head;
	    }
	    ListNode temp = head.next;
	    ListNode newHead = reverse(temp);
	    temp.next = head;
	    head.next = null;
	    return newHead;
	}
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4};
		ListNode node = ListNode.createNode(arr);
		ListNode nodet=node; 
		while (node  != null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
		ListNode reverse = new ReverseLinkList().reverse1(nodet);
		System.out.println("===============");
		while (reverse  != null) {
			System.out.print(reverse.val+" ");
			reverse=reverse.next;
		}
	}
	
	
	public ListNode reverse1(ListNode node) {
		ListNode pre = null;
		ListNode next = null;
		
		while (node !=null) {
			//
			next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		
		return pre;
	}
}
