package org.psring.leetcode.practive.y2022Feb;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sailor
 * @Date { 2022/2/19-22:33 }
 */
public class 煎饼翻转 {
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        for (int n = arr.length; n > 1 ;n--){
            // 获取下标
            int  index = 0;
            for ( int i = 1 ;i <n; i++){
                if(arr[i] >= arr[index]){
                    index = i;
                }
            }
            if(index == n - 1){
                continue;
            }
            revse(arr,index);
            revse(arr,n-1);
            res.add(index + 1);
            res.add(n);
        }
        System.out.println(arr);
        return res;
    }

    public static void revse(int [] arr,int index){
        for( int i = 0,j = index; i <j;i++ ,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int []{1,4,5,2,0}));
    }
}
