/**
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

#define N 3

/**
 方法一 
 遍历所有的格子, 
 每次当有填充时 检验 下面是否有效
 1. 每行是否重复
 2. 每列是否重复
 3. 每个子数独 是否重复

时间复杂度 O(N^2) , 细化到话 是 3倍的 N^2

容易出问题的点, 1. 没有排除自身 2. 计算子数独的索引出错 如果想不出来, 则举例 比如下面

 // row / N -> 0 0 0 1 1 1 2 2 2
 // col % N -> 1 2 3 1 2 3 1 2 3

 * 
*/

class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        // 遍历所有的空格
        int m = board.size();
        if (m == 0)
            return false;
        int n = board[0].size();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] != '.')
                {
                    if (!isValidSudoku(board, i, j))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    bool isValidSudoku(vector<vector<char>> &board, int row, int col)
    {
        char c = board[row][col];
        for (int i = 0; i < N * N; i++)
        {
            // 行
            if (i != col && board[row][i] == c)
            {
                cout << "board[row][i]" << i << endl;
                return false;
            }
            // 列
            if (i != row && board[i][col] == c)
            {
                cout << "board[i][col]" << i << endl;
                return false;
            }
            // 3 * 3 的 第几个格子
            // 该格子的所有位置
            // board[3∗(i/3)+j/3][3∗(i%3)+j%3]表示了对固定的宫ii，遍历格jj(即每次检查一个宫)
            // 第几个格子
            // int index = row / 3 + col / 3;
            // 3,6 ->
            int i_r = (row / N) * N + i / N;
            int i_c = (col / N) * N + i % N;
            if (i_r != row && i_c != col && board[i_r][i_c] == c)
            {
                cout << i_r << i_c << endl;
                return false;
            }
        }
        return true;
    }
};

/// 发现这样计算的速度略快, if (val1 > 1 || val2 > 1 || val3 > 1) 一起判断,比分开判断快不少
// 但是用这个方法, 比计算3词次的效果更差, 奇怪了
class SolutionCache
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        // 行
        vector<vector<int>> rows(9, vector(9, 0));
        // 列
        vector<vector<int>> cols(9, vector(9, 0));
        // 子数独
        vector<vector<int>> boxes(9, vector(9, 0));

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    // 之所以 -1 的原因是 申请空间是9个 数独数字最大是9 如果索引 9 的话会越界
                    int c = board[i][j] - '0' - 1;
                    // 填充
                    int val1 = ++rows[i][c];
                    int val2 = ++cols[j][c];
                    // 记忆的话 可以想一下, (5,7) 和 (7,5) 所得到的盒子索引不同, 说明row和col的优先级不同, 且索引是 通过 处理 row  和 处理 col 的最后和得到
                    int boxIndex = (i / 3) * 3 + j / 3;
                    int val3 = ++boxes[boxIndex][c];
                    if (val1 > 1 || val2 > 1 || val3 > 1)
                        return false;
                }
            }
        }
        return true;
    }
};