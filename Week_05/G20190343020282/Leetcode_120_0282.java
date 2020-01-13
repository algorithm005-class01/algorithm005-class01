package com.demo.test.leetcode;

import java.util.List;

/**
 * TODO
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 * @author houyujia
 * @since 2020/1/12
 */
public class DP_120 {


    public static int method(List<List<Integer>> listT) {
        int[] a =new int[listT.size()+1];
        for (int i = listT.size()-1; i >=0; i--) {
            for (int j = 0; j < listT.get(i).size(); j++) {
                a[j]=Math.max(a[j],a[j+1])+listT.get(i).get(j);
            }
        }
        return a[0];
    }
}
