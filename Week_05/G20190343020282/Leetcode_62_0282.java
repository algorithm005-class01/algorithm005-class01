package com.demo.test.leetcode;

/**
 * 动态规划题目-  最小路径
 * TODO
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“end”）。

 问总共有多少条不同的路径？  6x4

 start-> [][][][][][]
         [][][][][][]
         [][][][][][]
         [][][][][][] <- end


 * @author houyujia
 * @since 2020-01-09
 */
public class DP_62 {
    public static void main(String[] args) {
        System.out.println(method1(8, 8));

    }

    public static int method1(int m,int n) {
        int[][] pan=new int[m][n];
        for (int i = 0; i < m ; i++) {
            pan[0][i]=1;
        }
        for (int i = 0; i < n ; i++) {
            pan[i][0]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pan[i][j]=pan[i-1][j]+pan[i][j-1];
            }
        }
        return pan[m-1][n-1];
    }

}
