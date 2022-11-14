package org.psring.leetcode.practive.y2022Nov;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sailor
 * @Date { 2022/11/14-9:25 }
 * @desc 含有重复元素集合的组合
 */
public class RepetitionArrayListCombination {

    public static void main(String[] args) {
        int target = 8;
        int [] candidates = {10,1,2,7,6,1,5,3};
        List<List<Integer>> list = combinationSum2(candidates,target);
        System.out.println(list);
    }
    /**
     * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
     *
     *
     * 解题思路：回溯算法
     * 先排序
     * 从第一个开始计算叠加下一个是否等于目标值
     * 小于继续往下取，等于截止
     * 大于需要回溯，或者跳过取
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        backTrack(candidates,target,ret,new ArrayList<>(),0 ,0);

        return ret;
    }

    private static void backTrack(int[] candidates, int target, List<List<Integer>> ret, ArrayList<Integer> objects, int sum, int index) {
        //
        if (sum >= target) {
            System.out.println(objects);
            ret.add(new ArrayList<>(objects));
            return;
        }
        for ( int i = index; i<candidates.length ; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                // 剪枝
                return;
            }
            objects.add(candidates[i]);
            backTrack(candidates,target,ret,objects,sum + candidates[i],i+1);
            objects.remove(objects.size()-1);
        }
    }
}
