package com.jtel.ekoo;

/**
 * Created by Ju·Felix on 2019/12/29.
 */
public class LeetCode_74_0290 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 3;

        boolean searched = searchMatrix(matrix, target);

        System.out.println(searched);

    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int mLen = matrix.length;
        if (mLen == 0) {
            return false;
        }
        int nLen = matrix[0].length;
        if (nLen == 0) {
            return false;
        }
        for (int[] num : matrix) {
            int start = num[0];
            int end = num[nLen - 1];
            if (start <= target && target <= end) {
                for (int i : num) {
                    if (i == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
