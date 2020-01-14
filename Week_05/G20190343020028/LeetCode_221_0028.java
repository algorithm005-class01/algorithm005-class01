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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix.length > 0 ? matrix[0].length : 0;

        int[][] dp = new int[rowLength + 1][colLength + 1];
        int maxSideLen = 0;

        for (int r = 1; r <= rowLength; r++) {
            for (int c = 1; c <= colLength; c++) {
                // 如果当前位置是岛，查看是否能与之前相邻的位置组成更大的矩形
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r][c - 1], dp[r - 1][c]), dp[r - 1][c - 1]) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[r][c]);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
