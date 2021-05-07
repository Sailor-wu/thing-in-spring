package org.psring.leetcode.practive.y2021Apr;

import java.util.Arrays;

import org.omg.PortableInterceptor.DISCARDING;

/**
 * desc 加一
 * @author Sailor-why
 */
public class LeetCode_66 {

	public static void main(String[] args) {
		int[] digits=
			{0};
//			{9};
//			{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
//				{9,8,7,6,5,4,3,2,1,0};
//				{1,9,9,9};
		for (int i : new LeetCode_66().plusOne(digits)) {
			System.out.println(i);
		}
	}
	
	private int[] plusOne(int[] digits) {
		int len = digits.length;
		for (int i = len-1; i >=0 ; i--) {
			digits[i]++;//直接加 1
			digits[i]%=10;//取余
			if(digits[i]!=0) {// 非 0  结束返回原数组
				return digits;
			}
		}
		// 只有类似全是 999 才会执行到这    前面进一 后面全是 0
		digits = new int[len + 1];
		digits[0] = 1;
		return digits;
	}

	public int[] plusOne3(int[] digits) {
		int length = digits.length -1;
		
		while(true) {
			if(digits[length] + 1 <10) {
				digits[length] = digits[length]+1;
				break;
			}else if(digits[length] + 1 >=10) {
				digits[length] = 0;
				digits[length-1] = digits[length-1]+1;
				length--;
			}else {
				break;
			}
		}
		return digits;
	}
	
	public int[] plusOne2(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
			sb.append(i+"");
		}
        String str = String.valueOf(1+Long.valueOf(sb.toString()));
        int [] intArr = new int[str.length()];
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            intArr[i] = (int) ch[i] - 48;
        }
        return intArr;
    }
}
