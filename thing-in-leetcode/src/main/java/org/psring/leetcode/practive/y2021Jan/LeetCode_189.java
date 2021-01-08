package org.psring.leetcode.practive.y2021Jan;
/**
 * desc 旋转数组
 * 	给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 	示例 1:
	
	输入: [1,2,3,4,5,6,7] 和 k = 3
	输出: [5,6,7,1,2,3,4]
	解释:
	向右旋转 1 步: [7,1,2,3,4,5,6]
	向右旋转 2 步: [6,7,1,2,3,4,5]
	向右旋转 3 步: [5,6,7,1,2,3,4] 
 * @author Sailor-why
 */
public class LeetCode_189 {

	public static void main(String[] args) {
		int []  arrs =
//			{-1,-100,3,99};
			{1,2,3,4,5,6,7};
		int k = 
//				2;
				3;
		new LeetCode_189().rotate(arrs, k);
		
		for (int i : arrs) {
			System.out.println(i);
		}
	}
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k%n;
		reverse(nums, 0, n-1); // 全部旋转
		reverse(nums, k, n-1); // 不用旋转部分
		reverse(nums, 0, k-1); // 需要旋转部分
//		for (int i = 0; i < k; i++) {
//			moveArrElem(nums);
//		}
    }

	/**
	 * 	循环替换，把数组的当前位置的值，放到下一个位置，如果是最后一个，则放在第一个
	 * @param nums
	 * void
	 */
	private void moveArrElem(int[] nums) {
		int lastOne = nums[nums.length-1]; // 最后一个
		for (int i = nums.length -1; i >0; i--) {
			// 把数组的当前位置的值，放到下一个位置
			// 0  --  1  1位置的值，用0位置的值替换
			nums[i] = nums[i-1];
		}
		nums[0] = lastOne;
	}
	/**
	 * 	按位置替换   
	 * @param nums
	 * @param start
	 * @param end
	 * void
	 */
	private void reverse(int [] nums,int start ,int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start ++;
			end --;
		}
	}
}
