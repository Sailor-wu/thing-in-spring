package org.psring.leetcode.practive.y2021Aug;
/**
 * desc 一个整数  1出现的次数
 * @author Sailor-why
 */
public class LeetCode_233 {

	public static void main(String[] args) {
		LeetCode_233 code_233 = new LeetCode_233();
		int digitOne = code_233.countDigitOne(55);
		System.out.println(digitOne);
	}
	
	public int countDigitOne(int n) {
//		int digit = 1,res = 0;
//		
//		int high = n / 10,cur = n%10,low = 0;
//		
//		while(high !=0 || cur != 0) {
//			if(cur == 0) {
//				res += high * digit;
//			}else if(cur ==1) {
//				res += high * digit + low + 1;
//			}else {
//				res += (high + 1) * digit;
//			}
//			low+=cur * digit;
//			cur = high % 10;
//			high/=10;
//			digit*=10;
//		}
//		return res;
		int cnt = 0,preNum = 0,lastNum = n;
        int temp,i = 1;
        while(lastNum != 0){
            lastNum = lastNum / 10;
            temp =n / i % 10;
            if(temp > 1){
                cnt += (lastNum + 1) * i;
            }else if(temp == 1){
                //当前为1只需要考虑 0~高位拼接低位组成的数 之间有多少数
                cnt += lastNum * i + preNum + 1;
            }else if(temp == 0){
                cnt += lastNum * i;
            }
            preNum = i * temp + preNum;
            i *= 10;
        }
        return cnt;
	}
}
