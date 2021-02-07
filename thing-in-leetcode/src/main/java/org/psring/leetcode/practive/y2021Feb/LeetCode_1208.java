package org.psring.leetcode.practive.y2021Feb;
/**
 * desc 尽可能使字符串相等 
 * @author Sailor-why
 */
public class LeetCode_1208 {

	public static void main(String[] args) {
		
	}
	
	public int  equalSubstring(String ss,String tt,int max){
		int n = ss.length();
		ss = " "+ss;
		tt = " "+tt;
		char [] s = ss.toCharArray();
		char [] t = tt.toCharArray();
		int [] sum = new int[n+1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + Math.abs(s[i] - t[i]);
		}
		int l = 1,r = n;
		while (l < r) {
			int mid = l+r+1 >> 1;
			if(check(sum, mid, max)) {
				l = mid;
			}else {
				r = mid -1;
			}
		}
		return check(sum, r, max)?r:0;
	}
	
	public boolean check(int [] nums,int mid,int max) {
		for (int i = mid; i < nums.length; i++) {
			int tot = nums[i] - nums[i-mid];
			if(tot <= max) {
				return true;
			}
		}
		return false;
	}
}
