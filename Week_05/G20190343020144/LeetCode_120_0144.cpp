/**
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    int minimumTotal(vector<vector<int>> &triangle)
    {
        int m = triangle.size();
        if (m == 0)
            return 0;
        // 注意这里要计算的是 最后一行的数量
        int n = triangle[m - 1].size();
        if (n == 0)
            return 0;
        // 定义动态规划状态 f[i][j] 表示[i][j] 二维坐标的 最小路径和
        // 重复子问题 f[i][j] 可以分解为, 下一行的 f[i+1][j] + triangle[i][j] 或者下一行的 f[i+1][j+1] + triangle[i][j]  , 求其最小值即可
        // 迁移方程 f[i][j] = min(f[i+1][j+1],f[i+1][j+1]) + triangle[i][j];
        // 类似与爬楼梯,如果用自顶向下 会有很多重复子问题的计算, 可以采用 记忆法优化
        // 如果采用自底向上可以避免这个问题, 不过要注意 计算的纬度要从倒数第二层开始

        // 既然有动态状态, 需要有 状态维护数组, 优化的方案有, 直接采用triangle覆写, 或者因为自底向上过程中, 我们仅仅关心一层的状态, 可以优化为 一层

        return minimumTotalB2T2(triangle, m, n);
    }

    int minimumTotalB2T1(vector<vector<int>> &triangle, int m, int n)
    {
        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = 0; j < triangle[i].size(); j++)
            {
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }

    int minimumTotalB2T2(vector<vector<int>> &triangle, int m, int n)
    {
        // 状态数组 注意要 n+1 不是 n, 安全起见, 多分配一个比较稳妥
        vector<int> dp(n + 1, 0);
        // // 状态填充值为 0 , 那么可以计算dp[0]了, 外层循环可以从最下层开始
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 0; j < triangle[i].size(); j++)
            {
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
};