package org.psring.leetcode.practive.y2021May;
/**
 * desc 移除石子 获得最大的积分
 * @author Sailor-why
 * 你正在玩一个单人游戏，面前放置着大小分别为 a​​​​​​、b 和 c​​​​​​ 的 三堆 石子。
	每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
	给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
	
	示例 ：
	输入：a = 2, b = 4, c = 6
	输出：6
	解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
	- 从第一和第三堆取，石子状态现在是 (1, 4, 5)
	- 从第一和第三堆取，石子状态现在是 (0, 4, 4)
	- 从第二和第三堆取，石子状态现在是 (0, 3, 3)
	- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
	- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
	- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
	总分：6 分 。 
 */
public class LeetCode_1753 {

	public static void main(String[] args) {
		
	}
	
	public int maximumScore(int a, int b, int c) {
		
		if(a+b < c)return a+b;
		
        if(a+c < b)return a+c;
        
        if(c+b < a)return b+c;
        
        return (a+b+c)/2;
    }
	
}