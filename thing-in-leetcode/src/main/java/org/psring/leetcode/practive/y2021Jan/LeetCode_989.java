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
		LinkedList<Integer> res = new LinkedList<Integer>();
		int len = A.length , lastNum = K;
		int i = len -1; // 从后面开始添加
		while (i >=0 || lastNum > 0) {
			// 末位相加
			int temp = lastNum % 10 + (i >= 0? A[i]:0);
			// 每次都添加在前面
			res.addFirst(temp % 10);
			// 剩余的K 的值 等于  K 值除以10 + 末位相加的十位值
			lastNum = lastNum / 10 + temp /10;
			i--;
		}
		
		return res;
		
//		int len = A.length;
//		int lastNum = K;
//		LinkedList<Integer> ret = new LinkedList<>();
//		int i = len - 1;
//		while (i >= 0 || lastNum > 0) {
//			int tmp = lastNum % 10 + (i >= 0 ? A[i] : 0);
//			ret.addFirst(tmp % 10);
//			lastNum = lastNum / 10 + tmp / 10;
//			i--;
//		}
//		return ret;
	}

}
