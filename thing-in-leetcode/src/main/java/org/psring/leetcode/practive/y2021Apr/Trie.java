package org.psring.leetcode.practive.y2021Apr;
/**
 * desc 前缀树 
 * @author Sailor-why
 */
public class Trie {
	// 构建的 root 前缀树
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	/**
	 * desc 插入前缀树
	 * @param word
	 * void
	 */
	public void insert(String word) {
		TrieNode node = root;// 
		for (char c : word.toCharArray()) {
			if(node.next[c - 'a'] ==null) {
				// 不存在节点,构造新节点
				node.next[c - 'a'] = new TrieNode();
			}
			// 赋值
			node = node.next[c - 'a'];
		}
		// 标记结束
		node.isEnd = true;
	}
	/**
	 * desc 查询 
	 * @param word
	 * @return
	 * boolean
	 */
	public boolean search(String word) {
		TrieNode node = root;
		for(char c : word.toCharArray()) {
			node = node.next[c - 'a'];
			if(node == null) {
				return false;
			}
		}
		return node.isEnd;
	}
	/**
	 * desc 前缀匹配
	 * @param word
	 * @return
	 * boolean
	 */
	public boolean startWith(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			node = node.next[c - 'a'];
			if(node == null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 True
		System.out.println(trie.search("app"));     // 返回 False
		System.out.println(trie.startWith("app")); // 返回 True
		trie.insert("app");
		System.out.println(trie.search("app"));     // 返回 True 
	}
}
/**
 * desc 前缀树节点
 * @author Sailor-why
 */
class TrieNode{
	boolean isEnd;
	TrieNode [] next;
	/**
	 * 构造器
	 */
	public TrieNode() {
		isEnd = false;// 是否最后
		next = new TrieNode[26]; // 可以存26个字母数组
	}
}