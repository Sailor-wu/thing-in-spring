package org.psring.leetcode.practive.y2021May;
/**
 * desc 蓄水
 * @author Sailor-why
 */
public class LeetCode_LCP_33 {

	public static void main(String[] args) {
//		LeetCode_LCP_33 lcp_33 = new LeetCode_LCP_33();
//		int[] bucket=
//				{1,3};
//		int[] vat = 
//				{6,8};
//		int water = lcp_33.storeWater(bucket, vat);
//		System.out.println(water);
		

	    int i = 0;
	    int arr[] = {0,0,0};
	    for(; i<=3; i++){
	        arr[i] = 0;
	        System.out.println("hello world\n");
	    }

	}
	
	public int storeWater(int [] bucket,int [] vat) {
		
		int n = vat.length;
		int max = -1;
		
		for (int i = 0; i < n; i++) {
			if(vat[i] > max)
				max = vat[i];
		}
		if(max == 0)
			return 0;
		int min = 1000000;
		for (int i = 1; i <= max; i++) {
			int cur = i;
			for(int j = 0;j < n;j++) {
				int least = vat[j] / i + (vat[j] % i == 0?0:1);
				cur += Math.max(0, least - bucket[j]);
			}
			if(cur < min)
				min = cur;
		}
		return min;
	}
	
}
