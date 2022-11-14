package org.psring.leetcode.practive.y2022Jan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sailor
 * @Date { 2022/2/17-20:49 }
 */
public class 字母大小写全排列 {

    List<String> list = new ArrayList();
    public List<String> letterCasePermutation(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        getStr(0,chs,len);
        return list;
    }
    public void getStr(int index,char[]chs,int len){
        list.add(new String(chs));
        for(int i = index; i < len; i++){
            if(Character.isLetter(chs[i])){
                char tmp = chs[i];
                chs[i]^=32;
                System.out.println(chs);
                getStr(i + 1, chs, len);
                chs[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        字母大小写全排列 a = new 字母大小写全排列();
        String s = "a1b2";
        List<String> strings = a.letterCasePermutation(s);
        for (String s1:strings  ) {
            System.out.println(s1);
        }
    }
}
