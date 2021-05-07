package org.psring.leetcode.practive.y2021Apr;
/**
 * desc 多线程  按序打印
 * @author Sailor-why
 */
public class LeetCode_1114 {

	public static void main(String[] args) {
		String a = "    ";
		char[] charArray = a.toCharArray();
		int count = 0;
		for (char c : charArray) {
			if(' '== c) {
				count++;
			}
		}
		System.out.println(count);
	}
}
