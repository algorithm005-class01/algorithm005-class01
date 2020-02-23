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
        if (grid.length==0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] cur = new int[m];
        cur[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            cur[i] = cur[i-1]+grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            cur[0] = cur[0]+grid[0][j];
            for (int i = 1; i < m; i++) {
                cur[i] = Math.min(cur[i], cur[i-1])+grid[i][j];
            }
        }
        return cur[m-1];
    }

    private int minPath (int[][] grid) {
        if (grid.length==0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] pre = new int[m];
        int[] cur = new int[m];
        pre[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            pre[i] = pre[i-1]+grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            cur[0] = pre[0]+grid[0][j];
            for (int i = 1; i < m; i++) {
                cur[i] = Math.min(cur[i-1], pre[i])+grid[i][j];
            }
            pre = cur;
        }
        return pre[m-1];
    }

    private int twoDiemMinPath (int[][] grid) {
        //1. 子问题， bottom up (只能从左边或者上面到打最后))))
        // 2. 状态表
        //3. DP方程 dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j])
        if (grid.length==0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
