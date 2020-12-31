package org.psring.leetcode.practive.y2020Dec;

import java.util.Arrays;
import java.util.Comparator;

/**
 * desc 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * <p>由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * <p> 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 
 * <p>弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * @author Sailor-why
 */
public class LeetCode_452 {

	public static void main(String[] args) {
		int [][] arr = 
//				{{1,2},{3,4},{5,6},{7,8}};
//				{{10,16},{2,8},{1,6},{7,12}};
			{{-2147483646,-2147483645},{2147483646,2147483647}};
		int i = new LeetCode_452().shootBalloon(arr);
		System.out.printf("需要 %d 支箭。",i);
	}

	/**
	 * desc 
	 * int
	 */
	private int shootBalloon(int[][] arr) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		int res = 1;
		// 先排序  按照结束参照升序排序
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1] ,o2[1]);
			}
		});
		// 计算
		int preRight = arr[0][1];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][0] > preRight) {
				++res;
				preRight = arr[i][1];
			}
		}
		return res;
	}
}
