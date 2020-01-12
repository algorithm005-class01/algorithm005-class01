/**
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

推荐题解:
https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * 暴力解法
 * 和类似有效岛屿一样, 双重for循环
 * 从 matrix[i][j]  == 1 的点 , 像 右下方 去从 0 - maxlength 去一次一次遍历 是否符合 正方形的 概念
 * 时间复杂度 O((mn)^2) 空间复杂度 O(1)
*/

/**
 * 动态规划
 * 最难的 一个是定义状态, 
 * 一个是迁移方程的 不同条件
 * 
 * 最开始 我也像定义 dp[i][j] 毕竟是二维 ,但是 却无法推算出 相邻点与它的关系
 * 
 * 这里说明一点的是 特别重要, dp[i][j] 是以自身为正方形的终点 而不是 起点 计算的
 * 迁移方程主要是以下 dp 来进行
 * [i-1,j-1] [i-1,j]
 * [i,j-1]   [ij]
 * 
*/

// 这里我经常犯的错误是 把 ASCII码的 '1' 等同与 数值 1 了

#define min(a, b) ((a) < (b) ? (a) : (b))

class Solution
{
public:
    int maximalSquare(vector<vector<char>> &matrix)
    {
        int m = matrix.size();
        if (m == 0)
            return 0;
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxAreaLength = 0;
        int l1 = 0, l2 = 0, l3 = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 || j == 0)
                {
                    // 优化可以直接使用 matrix, 又是经常犯的错误是 '1' 与 1 的区别
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                else if (matrix[i][j] == '1')
                {
                    l1 = dp[i - 1][j], l2 = dp[i - 1][j - 1], l3 = dp[i][j - 1];
                    dp[i][j] = min(min(l1, l2), l3) + 1;
                }
                maxAreaLength = max(maxAreaLength, dp[i][j]);
            }
        }
        return maxAreaLength * maxAreaLength;
    }
};