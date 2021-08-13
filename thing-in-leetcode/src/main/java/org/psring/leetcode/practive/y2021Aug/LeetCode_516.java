package org.psring.leetcode.practive.y2021Aug;

import java.util.Arrays;

/**
 * desc 最长回文串 长度
 * 
 * @author Sailor-why
 */
public class LeetCode_516 {

	public static void main(String[] args) {
		LeetCode_516 code_516 = new LeetCode_516();
		String s = "aabaa";
		int subseq = code_516.longestPalindromeSubseq(s );
		System.out.println(subseq);
	}
	
	public int longestPalindromeSubseq1(String s) {
		char [] seq = s.toCharArray();
		int n = seq.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int l = n-1; l >= 0; --l) {
            for (int r = l + 1, max = 0; r < n; ++r) {
                int tmp = dp[r];
                if (seq[r] == seq[l])
                    dp[r] = max + 2;
                max = Math.max(tmp, max);
            }
        }
        int ret = 0;
        for (int i = 0; i < n; ++i)
            ret = Math.max(ret, dp[i]);
        return ret;
	}
	
	public int longestPalindromeSubseq(String s) {
		int len = s.length(), max = 0;
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			arr[c-'a'] = arr[c-'a'] + 1;
			if(arr[c-'a'] > max)
				max = arr[c-'a'];
		}
		
		return max;
	}
}
