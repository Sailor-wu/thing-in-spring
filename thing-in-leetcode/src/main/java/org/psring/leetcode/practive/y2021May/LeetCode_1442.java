package org.psring.leetcode.practive.y2021May;
/**
 * desc 形成两个异或相等数组的三元组数目
 * @author Sailor-why
 */
public class LeetCode_1442 {

	public static void main(String[] args) throws InterruptedException {
		
		LeetCode_1442 code_1442= new LeetCode_1442();
		int[] arr= 
			{
					2,3,1,6,7  // 满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
			};
		int i =0;
		while (true) {			
			
			
			if(i ==0) {
				i = code_1442.countTriplets(arr);
			}
			System.out.println(i);
			Thread.sleep(200);
		}
		
	}
	
	 public int countTriplets(int[] arr) {
		 int count = 0;
		 
		 int len = arr.length;
		 for (int i = 0; i < len; i++) {
			int xorsum = 0;
			for (int j = i; j < len; j++) {
				xorsum ^=arr[j];
				if(xorsum == 0) {
					count += j-i;
				}
			}
		}
		 return count;
	 }
}
