package org.psring.leetcode.practive;

/**
 * .回溯算法 时间复杂度 O(2^n)，是指数级的
 * 
 * @author Sailor-why
 *
 */
public class a0_1 {
	

	public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
	// cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
	// w背包重量；items表示每个物品的重量；n表示物品个数
	// 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
	// f(0, 0, a, 10, 100)

	public void f(int i, int cw, int[] items, int n, int w) {
		if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
			if (cw > maxW)
				maxW = cw;
			return;
		}
		f(i + 1, cw, items, n, w);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			f(i + 1, cw + items[i], items, n, w);
		}
	}

	// 动态规划 时间复杂度是 O(n*w)。n 表示物品个数，w 表示背包可以承载的总重量。
	class a0_2 {
		// weight:物品重量，n:物品个数，w:背包可承载重量
		public int knapsack(int[] weight, int n, int w) {
			boolean[][] states = new boolean[n][w + 1]; // 默认值false
			states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
			if (weight[0] <= w) {
				states[0][weight[0]] = true;
			}
			for (int i = 1; i < n; ++i) { // 动态规划状态转移
				for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
					if (states[i - 1][j] == true)
						states[i][j] = states[i - 1][j];
				}
				for (int j = 0; j <= w - weight[i]; ++j) {// 把第i个物品放入背包
					if (states[i - 1][j] == true)
						states[i][j + weight[i]] = true;
				}
			}
			for (int i = w; i >= 0; --i) { // 输出结果
				if (states[n - 1][i] == true)
					return i;
			}
			return 0;
		}
	}

	// 动态规划(降低空间消耗) 时间复杂度是 O(n*w)。n 表示物品个数，w 表示背包可以承载的总重量。
	class a0_3 {

		public int knapsack2(int[] items, int n, int w) {
			boolean[] states = new boolean[w + 1]; // 默认值false
			states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
			if (items[0] <= w) {
				states[items[0]] = true;
			}
			for (int i = 1; i < n; ++i) { // 动态规划
				for (int j = w - items[i]; j >= 0; --j) {// 把第i个物品放入背包
					if (states[j] == true)
						states[j + items[i]] = true;
				}
			}
			for (int i = w; i >= 0; --i) { // 输出结果
				if (states[i] == true)
					return i;
			}
			return 0;
		}

	}
}
