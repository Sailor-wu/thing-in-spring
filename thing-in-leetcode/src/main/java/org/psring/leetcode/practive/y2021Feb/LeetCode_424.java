package org.psring.leetcode.practive.y2021Feb;

import java.util.HashMap;
import java.util.Map;
/**
 * desc 滑动窗口   详解-https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
 * @author Sailor-why
 */
public class LeetCode_424 {
	public static void main(String[] args) {
		String s =
				"ABAB";
		int k=
				2;
		int characterReplacement = new LeetCode_424().characterReplacement(s, k);
		System.out.println(characterReplacement);
	}

	
	// 维护一个数组，来保存每个字符出现的次数
	private int[] map = new int[26];

	public int characterReplacement(String s ,int k) {
		if(s == null ) {
			return 0;
		}
		char [] chars = s.toCharArray();
		int left = 0;//表示窗口左边界
		int right = 0;//表示窗口右边界
		int historyCHarMax = 0;// 记录最大字符长度
		
		for (; right < chars.length; right++) {
			// 获取下标位置
			int index = chars[right] - 'A';
			// 记录在维护数组 
			map[index] ++;
			// 找到最长的字符，比较替换
			historyCHarMax = Math.max(historyCHarMax, map[index]);
			//判断窗口宽度（right - left +1） 是否大于最长纪录 加 k(history +k) 来决定窗口是否滑动，否则就扩张
			if(right - left +1 > historyCHarMax + k) {
				map[chars[left] - 'A']--;
				left++; // 滑动
			}
			
		}
		return chars.length - left;
	}
	
	
	
	public int characterReplacement1(String s ,int k) {
		if(s == null) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left =0,right = 0,maxCount = 0 ,len = s.length();
		while (right < len) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			maxCount = Math.max(maxCount,map.get(s.charAt(right)));
			
			if(right-left +1 -maxCount > k) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				left ++;
			}
			right++;
		}
		return right - left;
	}
}
