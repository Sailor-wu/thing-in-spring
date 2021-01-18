package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.psring.leetcode.practive.util.Utils;

/**
 * desc 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0
 * 开始）。 <br>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 <br>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 <br>
 * 示例 1: <br>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]] <br>
 * 输出："bacd" <br>
 * 解释： <br>
 * 交换 s[0] 和 s[3], s = "bcad" <br>
 * 交换 s[1] 和 s[2], s = "bacd" <br>
 * 思路： 并集查<br>
 * 简而言之：根据下标集合，去构建字符集合。将下标集合与字符集合 分别排序， <br>
 * 将排好序的下标和字符 一一对应即可。 <br>
 * 形象点说：从排好序的下标集合中 从左往右地取出对应字符，再将所有取出的字符 排序， <br>
 * 最后把排好序的字符从左到右插入回下标集合中的下标中。 <br>
 * 先找出所有能 互换 位置的 下标集合 <br>
 * 遍历所有 下标集合： <br>
 * 将当前 下标集合中所有下标对应的字符“抽出”，构成1个字符集合； <br>
 * 将字符集合 排序(字典序) <br>
 * 将字符集合 按顺序(从左到右) 插入回原字符串。 <br>
 * 下标 0 1 2 3 <br>
 * 字符 b d a c <br>
 * 能互换的下标集合为{0, 2, 3}，则取下标对应字符 作为1个字符集合{b, a, c}， <br>
 * 将字符集合 排序，得{a, b, c}， <br>
 * 按序插入回原字符串，得： <br>
 * 下标 0 1 2 3 <br>
 * 字符 a d b c
 * 
 * @author Sailor-why
 */
public class LeetCode_1202 {

	public static void main(String[] args) {
		String s =
				"dcab";
		int[][] arr = 
//			{ { 0, 3 }, { 1, 2 } };
			{ { 0, 3 }, { 1, 2 } ,{0,2}};

		List<List<Integer>> pairs = Utils.asList(arr);
		System.out.println(pairs);

		String string = new LeetCode_1202().doProcess(s, pairs);
		System.out.println("string:"+string);
		
	}

	private String doProcess(String s, List<List<Integer>> pairs) {
		int len = s.length();
		DSU dsu = new DSU(100000);

		// 构造下标集合
		System.out.println("=====构造下标集合=========");
		for (List<Integer> list : pairs) {
			dsu.nuion(list.get(0), list.get(1));
		}

		// 每个下标集合有1个leader，用leader作为key（唯一）,下标集合List--value
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		// 排序
		System.out.println("=====键值  集合=========");
		for (int i = 0; i < len; i++) {
			int key = dsu.find(i);
			map.computeIfAbsent(key, unused -> new ArrayList<Integer>()).add(i);
		}

		StringBuilder sb = new StringBuilder(s);

		for (List<Integer> list : map.values()) {
			if (list.size() > 1) {
				sort(sb, list);
			}
		}

		return sb.toString();
	}

	private void sort(StringBuilder sb, List<Integer> list) {
		int len = list.size();
		char[] array = new char[len];
		// 根据下标集合构建字符集合
		for (int i = 0; i < len; i++) {
			array[i] = sb.charAt(list.get(i));
		}
		// 
		Arrays.sort(array);

		// 将字符集，插回 sb
		for (int i = 0; i < len; i++) {
			sb.setCharAt(list.get(i), array[i]);
		}
	}

	

}

class DSU {
	int[] parent;

	public DSU() {
	}

	public DSU(int len) {
		parent = new int[len];
		for (int i = 0; i < len; ++i)
			parent[i] = i;
	}

	public int find(int x) {
		int i = parent[x] != x ? parent[x] = find(parent[x]) : x;
		System.out.printf("input :  %d , find: %d \n",x,i);
		return i;
	}

	//
	public void nuion(int x, int y) {
		parent[find(x)] = find(y);
	}
}