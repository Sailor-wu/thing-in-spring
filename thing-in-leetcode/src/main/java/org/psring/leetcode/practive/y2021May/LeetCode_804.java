package org.psring.leetcode.practive.y2021May;

import java.util.HashSet;

/**
 * desc 福尔摩斯密码
 * @author Sailor-why
 */
public class LeetCode_804 {

	private static String[] map = {
	        ".-",		//a
	        "-...",		//b
	        "-.-.",		//c
	        "-..",		//d
	        ".",		//e
	        "..-.",		//f
	        "--.",		//g
	        "....",		//h
	        "..",		//i
	        ".---",		//j
	        "-.-",		//k
	        ".-..",		//l
	        "--",		//m
	        "-.",		//n
	        "---",		//o
	        ".--.",		//p
	        "--.-",		//q
	        ".-.",		//r
	        "...",		//s
	        "-",		//t
	        "..-",		//u
	        "...-",		//v
	        ".--",		//w
	        "-..-",		//x
	        "-.--",		//y
	        "--.."		//x
	        };
	    public int uniqueMorseRepresentations(String[] words) {
	        if (words == null) return 0;
	        HashSet<String> set = new HashSet<String>();
	        for (String s : words) {
	            StringBuilder sb = new StringBuilder();
	            for (char c : s.toCharArray()) {
	                sb.append(map[c - 'a']);
	            }
	            System.out.println(s+"-->"+sb.toString());
	            set.add(sb.toString());
	        }
	        return set.size();
	    }
}
