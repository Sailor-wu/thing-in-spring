package org.psring.leetcode.practive.y2021Jan;

public class LeetCode_1128 {
	
	
	public static void main(String[] args) {
		int[][] arr=
//				{{1,2},{2,1},{3,4},{5,6}};
				{{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},
						{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},
						{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},
						{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}};
		int numEquivDominoPairs = new LeetCode_1128().numEquivDominoPairs(arr);
		System.out.println(numEquivDominoPairs);
	}
	
	public int numEquivDominoPairs(int[][] dominoes) {
		// int [] dp = new int[100];
		// int ans = 0;
		// for(int[] arr:dominoes){
		//    Arrays.sort(arr);
		// System.out.printf("%d + %d = %d \n",arr[0] , arr[1],(arr[0] + arr[1]));
		// ans += dp[arr[0] + arr[1]]++;
		// }
		// System.out.printf("jieguo:%d",ans);
		// return ans;

		int[] cnt = new int[100];
		int a, b;
		int res = 0;
		for (int[] arr : dominoes) {
			a = arr[0];
			b = arr[1];
			if (a > b) {
				res += cnt[b * 10 + a]++;
			} else {
				res += cnt[a * 10 + b]++;
			}
		}
		return res;
	}
}
