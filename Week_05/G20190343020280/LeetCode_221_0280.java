//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        return maxSqureArray(matrix);
    }

    private int maxSqureArray (char[][] matrix) {
        if (matrix.length==0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        int maxSize = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0 ||matrix[i][j]=='0') {
                    cur[j] = matrix[i][j]-'0';
                } else if (matrix[i][j]=='1') {
                    cur[j] = Math.min(Math.min(pre[j], pre[j-1]), cur[j-1])+1;
                }
                maxSize = Math.max(maxSize, cur[j]);
            }
            Arrays.fill(pre, 0);
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return maxSize*maxSize;

    }

    private int maxSquare (char[][] matrix) {
        //dp方程 dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1], dp[i][j]代表边长
        if (matrix.length==0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int maxLen = 0;

        for (int i = 0; i < column; i++) {
            dp[0][i] = matrix[0][i]-'0';
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (i==0 || j==0 || matrix[i][j]=='0') {
                    dp[i][j] = matrix[i][j]-'0';
                }
                if (matrix[i][j]=='1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
