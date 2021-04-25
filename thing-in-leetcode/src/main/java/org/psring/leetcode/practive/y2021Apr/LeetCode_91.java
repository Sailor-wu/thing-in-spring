package org.psring.leetcode.practive.y2021Apr;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_91 {

	public static void main(String[] args) {
		String encodingStr=
//				"11106";
//				"12";
				"226";
		int numDecodings =new LeetCode_91(). numDecodings(encodingStr);
		System.out.println(numDecodings);
	}

	public int numDecodings(String s) {
		if(s.length()==0) return 0;
		if(s.charAt(0)=='0') return 0;
		char[] cs = s.toCharArray();
		int last_2 = 1,last_1 = 1 ; // last_2 == i-2   last_1 == i -1
		for (int i = 1; i < cs.length; i++) {
			int temp = last_1;
			if(cs[i] == '0') {
				if (cs[i-1] == '1' || cs[i-1] == '2') {
					temp = last_2;
				}else {
					return 0;
				}
			}else if (cs[i-1] =='1' ||
					cs[i-1] == '2'
					&& cs[i] -'0' > 0
					&& cs[i] -'0' < 7) {
				temp += last_2;
			}
			last_2 = last_1;
			last_1 = temp;
		}
		return last_1;
	}

}
