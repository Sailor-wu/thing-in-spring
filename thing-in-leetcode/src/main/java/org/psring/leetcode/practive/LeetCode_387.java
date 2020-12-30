package org.psring.leetcode.practive;

import java.util.HashMap;
import java.util.HashSet;
 /*
 * @author Sailor-why
 *
 */
public class LeetCode_387 {
 
	public static void main(String[] args) {
		
		String s = "loveleetcode";//"leetcode";
		System.out.println(new LeetCode_387().countStr2(s));
	}
	
	public int countStr2(String s ) {
//		//只循环了26次
		
		int res = -1;
        // 循环判断，从a到z 判断 firstIndexOf   lastIndexOf 下标
        for(char i = 'a'; i <= 'z'; i++){
            int index = s.indexOf(i);
            int lastIndex = s.lastIndexOf(i);
            // 判断是否一样，一样就是不重复
            if(index == lastIndex && index != -1){
                
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
		
//        int result = s.length();
//        for (char c = 'a'; c <= 'z' ; c++) {
//            int firstIndex = s.indexOf(c);
//            int lastIndex = s.lastIndexOf(c);
//
//            //如果相等表示不重复
//            if(lastIndex == firstIndex && firstIndex != -1 ){
//                result = Math.min(firstIndex,result);
//            }
//        }
//        if(result != s.length()){
//            return result;
//        }
//        return -1;
	}
	public int countStr(String s ) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
		}
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if(charMap.getOrDefault(c, 0)==1) {
				return i;
			}
		}
		return -1;
	}
}
