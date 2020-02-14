package com.log8.week07;
/*
https://leetcode-cn.com/problems/counting-bits/description/
 */
public class Solution338 {
    //通过DP方程解决
    //dp[i] 表示i中1的个数
    //dp[i] = dp[(i&(i-1))] + 1;

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[(i&(i-1))] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 5;
        Solution338 s338 = new Solution338();
        int[] res = s338.countBits(num);
        for (int re : res) {
            System.out.print(re + ",");
        }
    }

}
