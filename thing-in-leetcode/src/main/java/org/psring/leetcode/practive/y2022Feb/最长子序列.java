package org.psring.leetcode.practive.y2022Feb;

/**
 * @author sailor
 * @Date { 2022/2/19-23:34 }
 */
public class 最长子序列 {
    public static int lengthOfLIS1(int[] nums) {
        int [] arr = new int[nums.length];
        int res = 0;
        for(int num : nums){
            int i = 0,j=res;
            while(i < j){
                int m = (i+j) /2;
                if(arr[m]< num){
                    i = m +1;
                }else{

                    j = m;
                }
            }
            arr[i] = num;
            if(res == j){
                res++;
            }
        }
        return res;
    }

    public static int lengthOfLIS(int[] nums) {
        int[] memo=new int[nums.length+1];
        int res=0;
        for(int num:nums)
        {
            int target=0;
            for(int i=res;i>0;i--)
            {
                if(memo[i]<num)
                {
                    target=i;
                    break;
                }
            }
            memo[target+1]=num;
            res=Math.max(res,target+1);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
