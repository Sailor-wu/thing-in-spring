package org.psring.leetcode.practive.y2021Apr;
/**
 * desc 字符串查找
 * @author Sailor-why
 */
public class LeetCode_28 {

	public static void main(String[] args) {
		String hay ="hello";
		String str = "ll";
		int index = new LeetCode_28().strStr(hay,str);
		int kmp = new LeetCode_28().KMP(hay, str);
		System.out.println(index +" ==== "+kmp);
	}

	/**
	 * desc 直接使用 jdk 接口
	 * @param hay1
	 * @param str
	 * @return
	 * int
	 */
	private int strStr(String hay, String str) {
		return hay.indexOf(str);
	}
	/**
	 * desc 使用 KMP 算法
	 * @param hay
	 * @param str
	 * @return
	 * int
	 */
	private int KMP(String haystack, String needle) {
		
		int n = haystack.length(),m = needle.length();
		if(m ==0) return 0;
		int [] pi = new int[m];
		for (int i = 1,j = 0; i < m; i++) {
			while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
				j = pi[j-1];
			}
			if(needle.charAt(i) == needle.charAt(j)) {
				j++;
			}
			pi[i] = j;
		}
		
		for (int i = 0,j = 0; i < n; i++) {
			while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = pi[j-1];
			}
			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}
			
			if(j == m) return i-m+1;
		}
		return -1;
	}
}
