package org.psring.leetcode.practive;
/**
 * .正则表达式   回溯算法   合理使用剪枝
 * .其他 深度优先搜索、八皇后、0-1 背包问题、图的着色、旅行商问题、数独、全排列、正则表达式匹配
 * @author Sailor-why
 *
 */
public class Pattern {
	private boolean matched = false;
	private char[] pattern; // 正则表达式
	private int plen; // 正则表达式长度

	public Pattern(char[] pattern, int plen) {
		this.pattern = pattern;
		this.plen = plen;
	}

	public boolean match(char[] text, int tlen) { // 文本串及长度
		matched = false;
		rmatch(0, 0, text, tlen);
		return matched;
	}

	private void rmatch(int ti, int pj, char[] text, int tlen) {
		if (matched)
			return; // 如果已经匹配了，就不要继续递归了
		if (pj == plen) { // 正则表达式到结尾了
			if (ti == tlen)
				matched = true; // 文本串也到结尾了
			return;
		}
		if (pattern[pj] == '*') { // *匹配任意个字符
			for (int k = 0; k <= tlen - ti; ++k) {
				rmatch(ti + k, pj + 1, text, tlen);
			}
		} else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
			rmatch(ti, pj + 1, text, tlen);
			rmatch(ti + 1, pj + 1, text, tlen);
		} else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
			rmatch(ti + 1, pj + 1, text, tlen);
		}
	}
}
