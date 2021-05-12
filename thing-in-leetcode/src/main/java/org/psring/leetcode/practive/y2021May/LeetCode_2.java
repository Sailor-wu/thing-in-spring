package org.psring.leetcode.practive.y2021May;
 

import org.psring.leetcode.practive.util.ListNode;
/**
 * desc 把两个链表的节点的值相加，拼装成新的链表
 * @author Sailor-why
 */
public class LeetCode_2 {

	public static void main(String[] args) {
		int[] arr = {9,9,9,9,9,9,9};
		int[] arr2 = {9,9,9,9};
		ListNode node = ListNode.createNode(arr);
		ListNode node2 = ListNode.createNode(arr2);
		LeetCode_2 code_2 = new LeetCode_2();
		ListNode node3 = code_2.addTwoNumbers(node, node2);
		ListNode.printNodeVal(node3);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    } 
	
	@Deprecated
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

		// 
		Long l1Str = dfs(l1,1);
		Long l2Str = dfs(l2,1);
		String string = String.valueOf(l1Str+l2Str);
		int len = string.length()-1;
		ListNode node = new ListNode(Integer.valueOf(string.substring(len)));
		ListNode nodeArr = node;
		for (int i = len-1; i>=0 ; i--) {
			ListNode nodeI = new ListNode(Integer.valueOf(string.substring(i, i+1)));
			nodeArr.next = nodeI;
			nodeArr = nodeI;
		} 
		return node;
    }

	private Long dfs(ListNode l,int beishu) {
		if(l== null)
			return 0l;
		long sum = 0l;
		sum += l.val * beishu;
		sum += dfs(l.next,beishu*10);
		return  sum;
	}
	
}
