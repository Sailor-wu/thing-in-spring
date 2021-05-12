package org.psring.leetcode.practive.y2021May;
/**
 * desc 子数组异或查询
 * @author Sailor-why
 */
public class LeetCode_1310 {

	// 1
	public int[] xorQueries1(int[] arr, int[][] queries) {
        //有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
        int [] prefix = new int[arr.length+1];

        for(int i = 1;i< prefix.length;i++){
            prefix[i] = prefix[i-1] ^ arr[i-1];
        }

        int ans [] = new int[queries.length];
        
        // 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
        for(int i = 0;i<queries.length;i++){
            int L = queries[i][0],R = queries[i][1];
            ans[i] = prefix[L] ^ prefix[R+1];
        }

        return ans;
    }
	
	public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        //计算每个位置的前缀和 pre[i] 表示前i项的异或和
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] querie : queries){
            //前面多异或的部分，再重复异或一次就可以抵消了
            //假设 求 [1, 2]，那么对于 [0, 2] 来说就是多异或了 [0, 0] 这个结果
            //根据 两个相同值异或结果为 0，那么我们可以再异或一次 [0, 0] 就将 [0, 0] 给抵消掉了
            //pre[querie[0]]代表了[0, 0]异或 pre[querie[1] + 1]代表了[0, 2]异或 其中[0, 0]异或两次
            //最后相当于[1, 2]异或
            ans[i++] = pre[querie[0]] ^ pre[querie[1] + 1];
        }
        return ans;
    }
}
