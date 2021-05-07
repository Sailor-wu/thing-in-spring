package org.psring.leetcode.practive.y2021Apr;

public class LeetCode_1011 {

	public static void main(String[] args) {
		LeetCode_1011 code = new LeetCode_1011();
		int d = 5;
		
		int[] weights =
				{1,2,3,4,5,6,7,8,9,10};
		
		int days = code.shipWithinDays(weights, d);
		System.out.println(days);
	}
	
	public int shipWithinDays(int[] weights, int D) { 
		int max = 0,sum =0;
		for (int i : weights) {
			max = Math.max(max, i);
			sum+=i;
		}
		
		int l = max,r = sum;
		
		while (l<r) {
			int mid = l + r>>1;
			if(check(weights,mid,D)) {
				r = mid;
			}else {
				l = mid+1;
			}
		}
		
		return r;
    }

	private boolean check(int[] weights, int mid, int d) {
		int n = weights.length;
		int cut = 1;
		for (int i = 1,sum = weights[0]; i < n; sum =0,cut++) {
			while (i < n && sum+weights[i] <= mid) {
				sum+= weights[i];
				i++;
			}
		}
		return cut -1 <=d;
	}
}
