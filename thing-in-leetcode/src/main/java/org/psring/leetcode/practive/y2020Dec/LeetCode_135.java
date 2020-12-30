package org.psring.leetcode.practive.y2020Dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * a 分发糖果 
	老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
	你需要按照以下要求，帮助老师给这些孩子分发糖果：
	每个孩子至少分配到 1 个糖果。
	相邻的孩子中，评分高的孩子必须获得更多的糖果。
	那么这样下来，老师至少需要准备多少颗糖果呢？
	示例 1:
		输入: [1,0,2]
		输出: 5
		解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
	示例 2:
		输入: [1,2,2]
		输出: 4
		解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
		     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
 * @author Sailor-why
 *
 */
public class LeetCode_135 {
	
	public static void main(String[] args) {
		int arr_student[] = {1,0,2};
		int count = candy(arr_student);
		System.out.printf("最少需要   %d  个糖果",count);
	}

	private static int candy(int[] arr_student) {
		// 创建两个数组
		int stuLength = arr_student.length;
		int left [] = new int[stuLength];
		int right [] = new int[stuLength];
		// 分配至少一个糖果
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		// 相对左边  评分高获取更多的糖果
		for (int i = 1; i < stuLength; i++) {
			// 当前的比当前下标减一的评分高，需要多一个糖果
			if(arr_student[i]  > arr_student[i-1])
				left[i]=left[i-1] + 1;
		}
		// 默认给相对左边的最少糖果数
		int count = left[stuLength - 1];
		for (int i = stuLength -2 ; i >=0; i--) {
			if(arr_student[i] > arr_student[i+1])
				right[i] = right[i+1] +1;
			count += Math.max(left[i], right[i]);
		}
		return count;
	}
	
}
