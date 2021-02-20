package org.psring.leetcode.practive.y2021Feb;

import java.util.List;

import org.psring.leetcode.practive.util.Utils;
/**
 * desc 三角路径最小
 * 		输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
		输出：11
		解释：如下面简图所示：
		   2
		  3 4
		 6 5 7
		4 1 8 3
		自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
 * @author Sailor-why
 */
public class LeetCode_120 {

	public static void main(String[] args) {
		int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
		int minimumTotal = new LeetCode_120().minimumTotal(Utils.asList(arr));
		System.out.println(minimumTotal);
	}
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()==0){
            return 0;
        }
        int  dp [] = new int[triangle.size()+1];

//        for(int i =  0;i<triangle.size();i++){
        for(int i =  triangle.size()-1;i>=0;i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0 ;j < curTr.size();j++){
                dp[j] = Math.min(dp[j],dp[j+1])+curTr.get(j);
            }
        }
        return dp[0];
//        return dp[triangle.size()-1];
    }
}
