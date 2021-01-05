package org.psring.leetcode.practive.y2021Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * desc 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
	例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
	分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
	上例中的 "xxxx" 分组用区间表示为 [3,6] 。
	我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
	找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
	
	示例 1：
	输入：s = "abbxxxxzzy"
	输出：[[3,6]]
	解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * @author Sailor-why
 */
public class LeetCode_830 {

	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		s =s+"A";
		char[] cs = s.toCharArray();
		int start = 0,end = 1;
		
		for (int i = 0; i <cs.length;i++) {
			if(cs[start] == cs[end]) {
				end++;
			}else {
				if(end - start >=3) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(start);
					temp.add(end-1);
					result.add(temp);
				}
				start=i;
				end =i+1;
			}
		}
		return result;
    }
	
	
	public List<List<Integer>> largeGroupPositions1(String s) {
		int start=0;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int end=1;end<s.length();end++){
            if(s.charAt(end)!=s.charAt(start)){
                if(end-start>=3){
                    result.add(Arrays.asList(start,end-1));
                }
                start=end;
            }
        }
        if(s.length()-start>=3){
            result.add(Arrays.asList(start,s.length()-1));
        }
        return result;
	}
	
}
