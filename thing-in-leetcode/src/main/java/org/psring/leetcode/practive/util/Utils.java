package org.psring.leetcode.practive.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

	public static List<List<Integer>> asList(int[][] arr) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		List<int[]> asList = Arrays.asList(arr);
		List<Integer> temp;
		for (int[] is : asList) {
			temp = new ArrayList<Integer>();
			for (Integer i : is) {
				temp.add(i);
			}
			pairs.add(temp);
		}
		return pairs;
	}
	
	public static List<List<String>> asList(String [][] arr) {
		List<List<String>> pairs = new ArrayList<List<String>>();
		List<String[]> asList = Arrays.asList(arr);
		List<String> temp;
		for (String [] is : asList) {
			temp = new ArrayList<String>();
			for (String i : is) {
				temp.add(i);
			}
			pairs.add(temp);
		}
		return pairs;
	}
}
