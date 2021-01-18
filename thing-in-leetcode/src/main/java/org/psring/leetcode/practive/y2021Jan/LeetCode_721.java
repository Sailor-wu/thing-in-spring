package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.psring.leetcode.practive.util.Utils;

/**
 * desc 账户合并 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素
 * accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。 一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。 账户本身可以以任意顺序返回。 示例 1： 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]] 输出： [["John",
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], ["John",
 * "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]] 解释： 第一个和第三个 John
 * 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 第二个 John 和 Mary
 * 是不同的人，因为他们的邮箱地址没有被其他帐户使用。 可以以任何顺序返回这些列表，例如答案
 * [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]
 * 也是正确的。
 * 
 * @author Sailor-why
 */
public class LeetCode_721 {
	
	public static void main(String[] args) {
		String[][] arr = 
			{{"John","johnsmith@mail.com","john_newyork@mail.com"}
		,{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},
		{"John","johnnybravo@mail.com"}};
		
		List<List<String>> accounts = Utils.asList(arr);
		List<List<String>> accountsMerge = new LeetCode_721().accountsMerge(accounts );
		for (List<String> list : accountsMerge) {
			System.out.println(list.toString());
		}
		
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// 记录邮箱对应的数组下标
		Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
		// 记录邮箱对应的名字
		Map<String,String> emailToName = new HashMap<String, String>();
		int emailCount = 0; // 邮箱总数
		String email_name = ""; // 邮箱对应的名字
		String email_ = ""; // 邮箱
		int size = 0;
		// 遍历
		for (List<String> list : accounts) {
			email_name = list.get(0);
			size = list.size();
			for (int i = 1; i < size; i++) {
				email_ = list.get(i);
				if(!emailToIndex.containsKey(email_)) {
					emailToIndex.put(email_, emailCount++);
					emailToName.put(email_, email_name);
				}
			}
		}
		UnionFind uf = new UnionFind(emailCount);
		String first_email = "",next_email = "";
		int first_index  = 0,next_index = 0;
		List<String> account = null;
		for (List<String> list : accounts) {
			first_email = list.get(1);
			first_index = emailToIndex.get(first_email);
			size = list.size();
			for (int i = 2; i < size; i++) {
				next_email = list.get(i);
				next_index = emailToIndex.get(next_email);
				uf.union(first_index, next_index);
			}
		}
		Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
		for (String email : emailToIndex.keySet()) {
			int index = uf.find(emailToIndex.get(email));
			account = indexToEmails.getOrDefault(index,new ArrayList<String>());
			account.add(email);
			indexToEmails.put(index, account);
		}
		// h合并
		List<List<String>> merged = new ArrayList<List<String>>();
		for (List<String> list : indexToEmails.values()) {
			Collections.sort(list);
			next_email = emailToName.get(list.get(0));
			account = new ArrayList<String>();
			account.add(next_email);
			account.addAll(list);
			merged.add(account);
		}
		return merged;
	}

}

class UnionFind {
	int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public void union(int index1, int index2) {
		parent[find(index2)] = find(index1);
	}

	public int find(int index) {
		if (parent[index] != index) {
			parent[index] = find(parent[index]);
		}
		return parent[index];
	}
}
