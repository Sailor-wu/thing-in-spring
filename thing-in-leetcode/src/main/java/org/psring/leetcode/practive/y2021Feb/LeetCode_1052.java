package org.psring.leetcode.practive.y2021Feb;

public class LeetCode_1052 {

	public static void main(String[] args) {
		int [] customers=
				{1,0,1,2,1,1,7,5};
		int [] grumpy = 
				{0,1,0,1,0,1,0,1};
		int X= 
				3;
		int maxSatisfied = new LeetCode_1052().maxSatisfied(customers, grumpy, X);
		System.out.println(maxSatisfied);
	}
	/**
	 * 1.先计算不生气的时候，顾客满意度
	 * 2.在根据X次，来匹配生气时候修改为不生气，使顾客满意
	 * @param customers
	 * @param grumpy
	 * @param X
	 * @return
	 * int
	 */
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		// 1
		int tatol = 0,len = customers.length;
		for (int i = 0; i < len; i++) {
//			 正常情况下不生气，满意顾客数
			if(grumpy[i]==0) {
				tatol+=customers[i];
			}
		}
		// 计算 X 前的 满意顾客数
		int zengjia = 0;
		for (int i = 0; i < X; i++) {
			// 
			zengjia += customers[i] * grumpy[i];
		}
		// 计算剩下的部分
		int maxZj = zengjia;
		for (int i = X; i < len; i++) {
			zengjia = zengjia - customers[i-X]*grumpy[i-X]+customers[i]*grumpy[i];
			maxZj = Math.max(maxZj, zengjia);
		}
		
		return tatol+maxZj;
	}
	public int maxSatisfied1(int[] customers, int[] grumpy, int X) {

        int winsum = 0;
        int rightsum = 0;
        int len = customers.length;
        //右区间的值
        for (int i = X; i < len; ++i) {
            if (grumpy[i] == 0) {
                rightsum += customers[i];
            }
        }
        //窗口的值
        for (int i = 0; i < X; ++i) {        
              winsum += customers[i];          
        }
        int leftsum = 0;
        //窗口左边缘
        int left = 1;
        //窗口右边缘
        int right = X;
        int maxcustomer = winsum + leftsum + rightsum;     
        while (right < customers.length) {
            //重新计算左区间的值，也可以用 customer 值和 grumpy 值相乘获得
            if (grumpy[left-1] == 0) {
                leftsum += customers[left-1];
            }
            //重新计算右区间值
            if (grumpy[right] == 0) {
                rightsum -= customers[right];
            }
            //窗口值
            winsum = winsum - customers[left-1] + customers[right];
            //保留最大值
            maxcustomer = Math.max(maxcustomer,winsum+leftsum+rightsum);
            //易懂窗口
            left++;
            right++;
        }        
        return maxcustomer;
    }
}
