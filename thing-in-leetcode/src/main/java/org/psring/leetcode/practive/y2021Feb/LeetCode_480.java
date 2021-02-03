package org.psring.leetcode.practive.y2021Feb;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * desc 滑动窗口 中位数
 * @author Sailor-why
 */
public class LeetCode_480 {

	public static void main(String[] args) {
		int[] nums = 
				{1,3,-1,-3,5,3,6,7};
		int k =
				2;
		double[] ds = LeetCode_480.medianSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ds));
	}
	
	 public static double[] medianSlidingWindow(int[] nums, int k) {
		 int len = nums.length;
		if(nums == null || len == 0) {
			 return new double[] {};
		 }
		 double[] res = new double[len - k + 1];
		 PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
		 PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
		 // 滑动窗口
		 int i = 0, j = 0;
		 int count = 0, index = 0;
		 for (i = 0; i < len - k +1; i++) {
			while (j < len && count < k) {
				add(maxHeap, minHeap, nums[j]);
				count++;
				j++;
			}
			if(count == k) {
				if(maxHeap.size() == minHeap.size()) {
					res[index++] = (maxHeap.peek() + minHeap.peek())*0.5;
				}else {
					res[index++] = maxHeap.peek();
				}
			}
			count--;
			remove(maxHeap, minHeap, nums[i]);
		}
		 return res;
	 }
	
	
	public static void add(PriorityQueue<Double> maxHeap,PriorityQueue<Double> minHeap,double num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
		return;
	}
	
	public static void remove(PriorityQueue<Double> maxHeap,PriorityQueue<Double> minHeap,double del) {
		if(del <= maxHeap.peek()) {
			maxHeap.remove(del);
		}else {
			minHeap.remove(del);
		}
		return;
	}
	
}
