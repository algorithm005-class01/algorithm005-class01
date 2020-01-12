/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.22%)
 * Likes:    342
 * Dislikes: 0
 * Total Accepted:    47K
 * Total Submissions: 74.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = m > 0 ? grid[0].size() : 0;
        if (m == 0) return 0;
        int dp[n]; dp[0] = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >=0; j--) {
                if (i == m-1 && j != n-1) {
                    dp[j] = dp[j+1] + grid[i][j];
                } else if (j == n-1 && i != m-1) {
                    dp[j] = dp[j] + grid[i][j];
                } else if (i == m-1 && j == n-1) {
                    dp[j] = grid[i][j];
                } else {
                    dp[j] = min(dp[j+1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[0];
    }
};
// @lc code=end

