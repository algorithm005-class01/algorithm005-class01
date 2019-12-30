package com.algorithm.week03;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_50_0100 {


    //使用分治
    public static double myPow(double x, int n) {
        //处理特殊情况
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        return  fastPow (x,N/2);

    }

    public static double fastPow(double x, long n) {
        //处理特殊情况
        if (n == 0) return 1d;
        if (n == 1) return x;

        double res = fastPow (x,n/2);
        double odd = fastPow (x,n%2);
        return res * res * odd;

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        mySubsets(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void mySubsets(List<List<Integer>> res , List<Integer> tmp , int[] nums,int index) {
        if (index == nums.length) {
            res.add(tmp);
            return;
        }

        //
        mySubsets(res, tmp, nums, index + 1);
        tmp.add(nums[index]);
        mySubsets(res, tmp, nums, index + 1);

        //
        tmp.remove(tmp.size() - 1);
    }


    public static void main(String[] args) {
        LeetCode_50_0100 l = new LeetCode_50_0100();
        System.out.println(JSON.toJSONString(l.subsets(new int[]{1,2,3})));

    }
}
