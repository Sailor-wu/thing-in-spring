package org.psring.leetcode.practive.y2021Feb;
/**
 * desc 非递减数列  
 * @author Sailor-why
 */
public class LeetCode_665 {

	public static void main(String[] args) {
		int[] nums=
				{4,2,1};
		new LeetCode_665().checkPossibility(nums);
	}
	
	public boolean checkPossibility(int [] nums){
		int count = 0;
		int length = nums.length;
		for (int i = 0; i < length -1; i++) {
			if(nums[i] > nums[i+1]) {
				if(++count == 2) {
					return false;
				}
				if(i ==0 || nums[i-1] <= nums[i+1]) {
					nums[i] = nums[i+1];
				}else {
					nums[i+1] = nums[i];
				}
			}
		}
		return true;
	}
}
