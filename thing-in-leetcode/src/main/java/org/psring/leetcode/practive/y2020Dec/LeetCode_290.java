package org.psring.leetcode.practive.y2020Dec;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 
中的每个非空单词之间存在着双向连接的对应规律。

 * @author Sailor-why
 *
 */
public class LeetCode_290 {
/**
 * 
pattern = "abba", str = "dog cat cat dog"

 a   b   b   a
dog cat cat dog
 ^
 i
 第一次遇到 a, 加入到 HashMap
 HashMap = {a:dog}

 a   b   b   a
dog cat cat dog
     ^
     i
 第一次遇到 b, 加入到 HashMap
 HashMap = {a: dog, b: cat}

 a   b   b   a
dog cat cat dog
         ^
         i
 HashMap = {a: dog, b: cat}
 第二次遇到 b, 判断 HashMap 中 b 的 value 和当前的单词是否符合
 符合的话继续判断, 不符合就返回 false
 
 a   b   b   a
dog cat cat dog
             ^
             i
 HashMap = {a: dog, b: cat}
 第二次遇到 a, 判断 HashMap 中 a 的 value 和当前的单词是否符合
 符合的话继续判断, 不符合就返回 false    
遍历结束，返回 true  
 */
	
	
	
	public static void main(String[] args) {
		//str = "dog cat cat dog" abba
		String pattern = "aaaa", str = "dog dog dog dog";
		System.out.println(doingThing(pattern,str));
	}

	/**
	 * 创建hashMap  保存 key(a,b)和Value(dog,cat)
	 *  
	 * @author {Sailor-why}
	 */
	private static boolean doingThing(String pattern, String str) {
		int len = pattern.length();
		// 
		HashMap<Character, String> hashMap = new HashMap<Character, String>(len+1);
		HashSet<String> set = new HashSet<String>();
		// 对应的字符串切分
		String[] strArr = str.split(" ");
		// 如果 pattern 不等于 数组长度，不匹配
		if(len != strArr.length) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			// 获取 key 字符
			char c = pattern.charAt(i);
			// 判断是否存在，存在就比较值
			if(hashMap.containsKey(c)) {
				if(!hashMap.get(c).equals(strArr[i])){
					return false;
				}
			}else {
				// 不存在就添加  添加之前，判断 str 的value 是否重复
				if(set.contains(strArr[i])) {
					return false;
				}
				hashMap.put(c, strArr[i]);
				set.add(strArr[i]);
			}
		}
		return true;
	}
	
	
}
