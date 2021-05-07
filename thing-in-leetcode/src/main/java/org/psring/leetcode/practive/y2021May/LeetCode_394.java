package org.psring.leetcode.practive.y2021May;
/**
 * desc 字符串解码
 * @author Sailor-why
 */
public class LeetCode_394 {

	public static void main(String[] args) {
		LeetCode_394 code_394 = new LeetCode_394();
		String s =
//				"3[a]2[bc]";
//				"3[a2[c]]";
//				"2[abc]3[cd]ef";
				"abc3[cd]xyz";
		String string = code_394.decodeString(s);
		System.out.println(string);
	}
	
	public String decodeString(String s ) {
		// 递归处理
		return dfs(s,0)[0];
	}

	private String[] dfs(String s, int i) {
		StringBuilder sb = new StringBuilder();
		int multi = 0; // 记录出现的数字
		while(i < s.length()) {
			// 是否是数字
			char c = s.charAt(i);
			if(c >='0' && c <='9') {
				multi = multi * 10 +Integer.parseInt(String.valueOf(c));
			}else if (c == '[') {
				// 中括号 开始
				String temp [] = dfs(s, i+1);
				i = Integer.parseInt(temp[0]);
				while (multi > 0) {
					sb.append(temp[1]);
					multi--;
				}
			}else if (c == ']') {
				// 中括号 结束
				return new String [] {String.valueOf(i),sb.toString()};
			}else {
				sb.append(String.valueOf(c));
			}
			i++;
			
		}
		return new String[] {sb.toString()};
	}
}
