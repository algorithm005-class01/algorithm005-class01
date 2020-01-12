//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        // 1. 子问题：当前点到达最后点的最小距离
        // 2. 状态定义：dp[row][col]
        // 3. DP 方程：dp[row][col] = grid[row][col] + min(dp[row - 1][col], dp[row][col - 1])

        int rowLength = grid.length;
        int colLength = grid[0].length;

        int[][] dp = new int[rowLength][colLength];

        for (int r = rowLength - 1; r >= 0; r--) {
            for (int c = colLength - 1; c >= 0; c--) {
                // 最后终结的节点，返回当前值
                if (r == rowLength - 1 && c == colLength - 1) {
                    dp[r][c] = grid[r][c];
                }
                // 最下面的一行，只需要累加右边的值
                else if (r == rowLength - 1 && c != colLength - 1) {
                    dp[r][c] = grid[r][c] + dp[r][c + 1];
                }
                // 最右边的一列，只需要累加下面的值
                else if (r != rowLength - 1 && c == colLength - 1) {
                    dp[r][c] = grid[r][c] + dp[r + 1][c];
                }
                // 如果存在下面、右边节点，当前最小路径 = 当前节点长度 + min(下面节点, 右面节点)
                else {
                    dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
