/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution
{
public:
    vector<vector<string>> solveNQueens(int n)
    {
        // 斜线记录
        vector<pair<int, int>> locations;

        vector<vector<string>> ans;
        vector<string> path;
        // 回溯处理,并剪枝
        __helper(ans, path, locations, 0, n);
        return ans;
    }

private:
    void __helper(vector<vector<string>> &ans,
                  vector<string> &path,
                  vector<pair<int, int>> &locations,
                  int curRow, int n)
    {
        if (curRow == n)
        {
            ans.push_back(path);
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
            //
            path.push_back(buildQ(n, i));
            __helper(ans, path, locations, curRow + 1, n);
            path.pop_back();
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

    // 某一行指定列的 棋盘分布
    string buildQ(int n, int col)
    {
        string q = "";
        for (int i = 0; i < n; i++)
        {
            q += i == col ? 'Q' : '.';
        }
        return q;
    }
};

class Solution2
{
public:
    vector<vector<string>> solveNQueens(int n)
    {
        // 行记录
        set<int> rRows;
        // 列记录
        set<int> rCols;
        // 斜线记录
        vector<pair<int, int>> locations;

        vector<vector<string>> ans;
        vector<string> path;
        // 回溯处理,并剪枝
        __helper(ans, path, rRows, rCols, locations, 0, n);
        return ans;
    }

private:
    void __helper(vector<vector<string>> &ans,
                  vector<string> &path,
                  set<int> &rRows,
                  set<int> &rCols,
                  vector<pair<int, int>> &locations,
                  int curRow, int n)
    {
        if (curRow == n)
        {
            ans.push_back(path);
            return;
        }

        // 当前row的所有选择
        for (int i = 0; i < n; i++)
        {
            // 是否符合条件
            if (!validQ(curRow, i, rRows, rCols, locations))
            {
                continue;
            }
            rRows.insert(i);
            rCols.insert(curRow);
            locations.push_back(make_pair(curRow, i));
            //
            path.push_back(buildQ(n, i));
            __helper(ans, path, rRows, rCols, locations, curRow + 1, n);
            rRows.erase(i);
            rCols.erase(curRow);
            path.pop_back();
            locations.pop_back();
        }
    }

    bool validQ(int curRow, int curCol, set<int> &rRows, set<int> &rCols, vector<pair<int, int>> &locations)
    {
        // 如果rRows中不包含 curCol, rCols 不含 curRow
        if (rRows.count(curCol))
            return false;
        if (rCols.count(curRow))
            return false;
        // 倾斜的 ,2,2, 00
        for (pair<int, int> location : locations)
        {
            if (location.first - curRow == location.second - curCol ||
                location.first - curRow == curCol - location.second)
            {
                return false;
            }
        }
        return true;
    }

    // 某一行指定列的 棋盘分布
    string buildQ(int n, int col)
    {
        string q = "";
        for (int i = 0; i < n; i++)
        {
            q += i == col ? 'Q' : '.';
        }
        return q;
    }
};

class Solution3
{
public:
    vector<vector<string>> solveNQueens(int n)
    {
        vector<int> qRows;
        vector<vector<string>> ans;
        vector<string> path;
        solveNQueens(n, 0, qRows, path, ans);
        return ans;
    }

    void solveNQueens(int n, int c_row, vector<int> &qRows, vector<string> &path, vector<vector<string>> &ans)
    {
        if (c_row == n)
        {
            ans.push_back(path);
            return;
        }

        // 遍历行
        // 记录行 比如 [1,3] 即 [0,1] 和 [1,3] 处包含 Q
        // 遍历列
        for (int col = 0; col < n; col++)
        {
            // 该位置是否可以填充皇后,
            // ① 该行前面没有填充 肯定没有
            // ② 该列前面没有填充  遍历 qRows
            bool contains1 = find(qRows.begin(), qRows.end(), col) != qRows.end();
            // ③ 该对角线 \ 没有填充 对角线 斜率是一致的(y=x或者-x) 即作差是否相等 或者 相反; 此处为相等
            // 四 该对角线 / 没有填充 此处相反
            if (contains1 || diagonalContains(qRows, c_row, col))
                continue;
            // 填充记录
            qRows.push_back(col);
            // 生成 当前行的 string
            path.push_back(buildQ(n, col));
            solveNQueens(n, c_row + 1, qRows, path, ans);
            // reset
            qRows.pop_back();
            path.pop_back();
        }
    }

    bool diagonalContains(vector<int> &qRows, int c_row, int c_col)
    {
        bool c = false;
        for (int i = 0; i < qRows.size(); i++)
        {
            bool f1 = (i - c_row) == (qRows[i] - c_col);
            bool f2 = (i - c_row) == (c_col - qRows[i]);
            if (f1 || f2)
            {
                c = true;
                break;
            }
        }
        return c;
    }

    string buildQ(int n, int col)
    {
        string q = "";
        for (int i = 0; i < n; i++)
        {
            q += i == col ? 'Q' : '.';
        }
        return q;
    }
};