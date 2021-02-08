package org.psring.leetcode.practive.y2021Feb;

/**
 * desc 最长湍流子数组
 * 
 * @author Sailor-why
 */
public class LeetCode_978 {

	public static void main(String[] args) {

		int[] arr =
				{9,4,2,10,7,8,8,1,9};
		int size = new LeetCode_978().maxTurbulenceSize(arr);
		System.out.printf("最长：%d !",size);
	}

	public int maxTurbulenceSize(int[] arr) {
		int n = arr.length, ret = 1, left = 0, right = 0;
		while (right < n - 1) {

			if (left == right) {
				if (arr[left] == arr[left + 1]) {
					left++;
				}
				right++;
			} else {
				/**
				 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 或 若 i <= k <
				 * j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
				 */
				if ((arr[right - 1] < arr[right] && arr[right] > arr[right + 1])
						|| arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
					System.out.printf("arr[right - 1] = %d \t,arr[right] = %d \t,arr[right + 1] = %d \t \n",arr[right - 1],arr[right],arr[right+1]);
					right++;
				} else {
					left = right;
				}
			}
			ret = Math.max(ret, right - left + 1);
		}
		return ret;
	}

}
