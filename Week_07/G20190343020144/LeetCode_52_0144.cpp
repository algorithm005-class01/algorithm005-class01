/**
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int totalNQueens(int n)
    {
        // 斜线记录
        vector<pair<int, int>> locations;
        int ans = 0;
        // 回溯处理,并剪枝
        __helper(ans, locations, 0, n);
        return ans;
    }

private:
    void __helper(int &ans,
                  vector<pair<int, int>> &locations,
                  int curRow, int n)
    {
        if (curRow == n)
        {
            ans++;
            return;
        }

        // 当前row的所有选择
        for (int i = 0; i < n; i++)
        {
            // 是否符合条件
            if (!validQ(curRow, i, locations))
            {
                continue;
            }
            locations.push_back(make_pair(curRow, i));
            __helper(ans, locations, curRow + 1, n);
            locations.pop_back();
        }
    }

    bool validQ(int curRow, int curCol, vector<pair<int, int>> &locations)
    {
        // 如果rRows中不包含 curCol, rCols 不含 curRow
        // 倾斜的 ,2,2, 00
        int row = 0, col = 0;
        for (pair<int, int> location : locations)
        {
            row = location.first;
            col = location.second;
            if (row - curRow == col - curCol ||
                row - curRow == curCol - col ||
                row == curRow ||
                col == curCol)
            {
                return false;
            }
        }
        return true;
    }
};