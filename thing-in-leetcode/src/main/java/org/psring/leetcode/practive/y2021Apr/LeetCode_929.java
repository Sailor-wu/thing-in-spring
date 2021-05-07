package org.psring.leetcode.practive.y2021Apr;

import java.util.HashSet;

public class LeetCode_929 {

	public static void main(String[] args) {
		String[] emails=
				{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int emails2 = new LeetCode_929().numUniqueEmails(emails);
		System.out.println(emails2);
		for (String string : hashSet) {
			System.out.println(string);
		}
	}
	static HashSet<String> hashSet = new HashSet<String>();
	
	public int numUniqueEmails(String[] emails) {
		for (String email : emails) {
			String[] split = email.split("@");
			String name = split[0].substring(0, split[0].indexOf("+")>0?split[0].indexOf("+"):split[0].length()).replaceAll("\\.", "");
			hashSet.add(name+"@"+split[1]);
		}
		return hashSet.size();
	}
//	public int numUniqueEmails(String[] emails) {
//		for (String string : emails) {
//			String[] split = string.split("@");
//			String firstStr = split[0];
//			String lastSrtr =split[1].substring(0, split[1].lastIndexOf("."));
//			if(lastSrtr.indexOf(".") > 0 ||lastSrtr.indexOf("+") > 0) {
//				continue;
//			}
//			String replaceAll = firstStr.replaceAll("\\.","");
//			String substring = replaceAll.substring(0, firstStr.indexOf("+"));
//			if(!hashSet.contains(substring)){
//				hashSet.add(substring);
//			}
//			
//		}
//		return hashSet.size();
//	}
}
