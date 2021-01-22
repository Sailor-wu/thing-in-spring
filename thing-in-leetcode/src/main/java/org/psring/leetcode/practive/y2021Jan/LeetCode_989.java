package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_989 {

	public static void main(String[] args) {

		int[] A =
//			{9,9,9,9,9,9,9,9,9,9};
				{1,2,8,8};
//				{ 0 };
		int K = 
//				0;
//				1;
				34;
		List<Integer> list = new LeetCode_989().addToArrayForm(A, K);
		for (Integer integer : list) {
			System.out.println(integer + "  ");
		}
	}

	public List<Integer> addToArrayForm(int[] A, int K) {
		int len = A.length;
		int lastNum = K;
		LinkedList<Integer> ret = new LinkedList<>();
		int i = len - 1;
		while (i >= 0 || lastNum > 0) {
			int tmp = lastNum % 10 + (i >= 0 ? A[i] : 0);
			ret.addFirst(tmp % 10);
			lastNum = lastNum / 10 + tmp / 10;
			i--;
		}
		return ret;
	}

}
