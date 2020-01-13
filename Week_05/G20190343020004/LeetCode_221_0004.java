package com.zyh.test.leetcode;

public class LeetCode_221_0004 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        max = 1;
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
                if (matrix[i][j] == '1')
                    result[i][j] = 1;
            }
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (matrix[i][j] == '1') {
                    result[i][j] = Math.min(result[i - 1][j], Math.min(result[i][j - 1], result[i - 1][j - 1])) + 1;
                    max = Math.max(max, result[i][j]);
                }
            }
        }
        return max * max;
    }
}
