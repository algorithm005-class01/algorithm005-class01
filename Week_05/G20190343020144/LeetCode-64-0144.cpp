/**
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int minPathSum(vector<vector<int>> &grid)
    {
        int m = grid.size();
        if (m == 0)
            return 0;
        int n = grid[0].size();
        // 定义状态 f[i][j] 最小路径和
        // 数组
        // 方程  f[i][j] =  min(f[i+1][j] , f[i][j+1]) + g[i][j], 自顶向上 (备忘录), 太麻烦, 用自底向上
        vector<vector<int>> memo(m + 1, vector<int>(n + 1, 0));

        // 初始化边缘的值  这一步非常关键, 如果仅仅用之前创建数组的 初始值 0 会有问题
        // 最后一行
        for (int i = n - 1; i >= 0; i--)
        {
            // 当前 + 后面一个
            memo[m - 1][i] = grid[m - 1][i] + memo[m - 1][i + 1];
        }
        // 最右侧一行
        for (int i = m - 1; i >= 0; i--)
        {
            // 当前 + 下面一个
            memo[i][n - 1] = grid[i][n - 1] + memo[i + 1][n - 1];
        }
        for (int i = grid.size() - 2; i >= 0; i--)
        {
            for (int j = grid[i].size() - 2; j >= 0; --j)
            {
                memo[i][j] = min(memo[i + 1][j], memo[i][j + 1]) + grid[i][j];
            }
        }
        return memo[0][0];
    }
};