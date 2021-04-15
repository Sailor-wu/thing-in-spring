package org.psring.leetcode.practive.y2021Apr;

import java.util.Arrays;
/**
 * desc 打家劫舍1    2
 * @author Sailor-why
 */
public class LeetCode_213 {

	public static void main(String[] args) {
		
	}
	
	public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums,0,len -1)),myRob(Arrays.copyOfRange(nums,1,len)));
    }

	
    public int myRob(int [] nums){
        int shangyige = 0,dangqian = 0,temp;
        for(int num :nums){
            temp = dangqian;
            dangqian = Math.max(shangyige+num,dangqian);
            shangyige = temp;
        }
        return dangqian;
    }
}
