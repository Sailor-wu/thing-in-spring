package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * desc 可被5整除的二进制前缀<br>
 * 给定由若干 0 和 1 组成的数组 A。<br>
 * 我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。<br>
 * 示例 1：<br>
 * 输入：[0,1,1]<br>
 * 输出：[true,false,false]<br><br>
 * 解释：<br>
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。 <br>
 * 
 * @author Sailor-why
 */
public class LeetCode_1018 {

	public static void main(String[] args) {
		int []arr = 
//				{0,1,0};
			{0,1,1,1,1,1};
		List<Boolean> list = new LeetCode_1018().prefixesDivBy4(arr);
		for (Boolean boolean1 : list) {
			System.out.print("\t"+boolean1);
		}
	}
	/**
	 * 	内存消耗 会少点
	 * @param A
	 * @return
	 * List<Boolean>
	 */
	 public List<Boolean> prefixesDivBy5(int[] A) {
	        List<Boolean> ans = new ArrayList<>();
	        
	        int num = 0;
	        for (int i = 0;i < A.length;i++) {
	            num <<= 1;
	            num += A[i];
	            num %= 10;
	            ans.add(num % 5 == 0);
	        }
	        
	        return ans;
	    }
	 
	 public List<Boolean> prefixesDivBy4(int[] A) {
	        List<Boolean> list = new ArrayList<Boolean>();
	        int prefix = 0;
	        int length = A.length;
	        for (int i = 0; i < length; i++) {
	            prefix = ((prefix << 1) + A[i]) % 5;
	            list.add(prefix == 0);
	        }
	        return list;
	    }
	 /**
	  * 	执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
			内存消耗：39.5 MB, 在所有 Java 提交中击败了8.45%的用户
	  * @param A
	  * @return
	  * List<Boolean>
	  */
	 public List<Boolean> prefixesDivBy3(int[] A) {
         Boolean[] ans = new Boolean[A.length];
		    Arrays.fill(ans, false);
			int x=0;
			for (int i = 0; i < A.length; i++) {
				x=2*x+A[i];
				x=x%5;
				if(x==0) ans[i] =true;
		    }
		return Arrays.asList(ans);
    }
}
