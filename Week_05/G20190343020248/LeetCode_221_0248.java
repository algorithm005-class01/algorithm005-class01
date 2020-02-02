package com.gome.study;
/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */


/**
 * 1.从 (0,0) 开始，对原始矩阵中的每一个 1，将当前元素的值更新为
 * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
 * <p>
 * 2.用一个变量记录当前出现的最大边长，这样遍历一次，找到最大的正方形边长
 * maxsqlen，那么结果就是 maxsqlen^2
 */

public class LeetCode_221_0248 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}