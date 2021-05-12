package org.psring.leetcode.practive.util;

public class ListNode {
	public int val;
	public ListNode next;

	ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static ListNode createNode(int[] arr) {
		if(arr.length<=0) {
			throw new RuntimeException(ListNode.class.getName()+":createNode ----创建节点异常.");
		}
		ListNode node = new ListNode(arr[0]);
		ListNode nodeArr = node;
		for (int i = 1; i< arr.length ; i++) {
			ListNode nodeI = new ListNode(arr[i]);
			nodeArr.next = nodeI;
			nodeArr = nodeI;
		}
		return node;
	}

	public static void printNodeVal(ListNode node3) {
		while (node3!=null) {
			System.out.print(node3.val+"-");
			node3 = node3.next;
		}
	}
}
