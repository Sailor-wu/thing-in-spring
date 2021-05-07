package org.psring.leetcode.practive.y2021Apr;

import java.util.Arrays;

public class LeetCode_1695 {

	public static void main(String[] args) {
		int[] nums = 
//				{4,2,4,5,6};
//			{5,2,1,5,2,1,2,5};
			{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
		System.out.println(maximumUniqueSubarray(nums ));
	}
	
	public static int maximumUniqueSubarray(int[] nums) {
		Arrays.sort(nums);
        int pre = nums[0],sum = nums[0];
        for(int i = 1;i <nums.length;i++){
            int temp = nums[i];
            // 当前和前面的一样
            if(pre == temp){
                continue;
            }
            
            sum +=temp;
            System.out.printf("%d + %d = %d \n",sum,temp ,sum);
            pre = temp;
        }
        return sum;
	}
}
