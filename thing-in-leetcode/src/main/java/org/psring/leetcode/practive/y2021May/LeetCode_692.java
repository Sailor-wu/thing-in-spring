package org.psring.leetcode.practive.y2021May;
/**
 * desc 查看 前 K 个高频单词
 * @author Sailor-why
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class LeetCode_692 {

	public static void main(String[] args) {
		int k = 2;
		String[] words = {
				"i", "love", "leetcode", "i", "love", "coding"
		};
		List<String> list = topKFrequent(words, k);
		for (String string : list) {
			System.out.print(string+" ");
		}
	}

	/**
	 * 	使用 map 加 排序算法
	 * 	我们利用哈希表记录每一个字符串出现的频率，
	 * 	然后将哈希表中所有字符串进行排序，排序时，如果两个字符串出现频率相同，那么我们让两字符串中字典序较小的排在前面，
	 * 	否则我们让出现频率较高的排在前面。最后我们只需要保留序列中的前
	 * 	kk 个字符串即可。
	 * 
	 * @param words
	 * @param k
	 * @return List<String>
	 */
	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String string : words) {
			// 存放 单词 和出现的次数
			map.put(string, map.getOrDefault(string, 0) + 1);
		}
		List<String> rec = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			rec.add(entry.getKey());// 记录词
		}
		
		Collections.sort(rec,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int i = map.get(o1)==map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1);
				System.out.printf("word1:%s , word2:%s , i : %d  \n",o1,o2,i);
				return i;
			}
		});
		
		return rec.subList(0, k);
	}
}
