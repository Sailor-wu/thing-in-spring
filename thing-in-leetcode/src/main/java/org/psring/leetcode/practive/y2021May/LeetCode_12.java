package org.psring.leetcode.practive.y2021May;
/**
 * desc 数字转罗马字符   1 <= num <= 3999
 * @author Sailor-why
 */
public class LeetCode_12 {

	
	public static void main(String[] args) {
		LeetCode_12 code_12 = new LeetCode_12();
		int num = 5555;
		String roman = code_12.intToRoman(num);
		System.out.println(roman);
		
	}
	
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                num -= 1000;
                sb.append('M');
            }
            else if(num >= 900){
                num -= 900;
                sb.append("CM");
            }
            else if(num >= 500){
                num -= 500;
                sb.append("D");
            }
            else if(num >= 400){
                num -= 400;
                sb.append("CD");
            }
            else if(num >= 100){
                num -= 100;
                sb.append("C");
            }
            else if(num >= 90){
                num -= 90;
                sb.append("XC");
            }
            else if(num >= 50){
                num -= 50;
                sb.append("L");
            }
            else if(num >= 40){
                num -= 40;
                sb.append("XL");
            }
            else if(num >= 10){
                num -= 10;
                sb.append("X");
            }
            else if(num >= 9){
                num -= 9;
                sb.append("IX");
            }
            else if(num >= 5){
                num -= 5;
                sb.append("V");
            }
            else if(num >= 4){
                num -= 4;
                sb.append("IV");
            }
            else if(num >= 1){
                num -= 1;
                sb.append("I");
            }
        }
        return sb.toString();
	}
}
