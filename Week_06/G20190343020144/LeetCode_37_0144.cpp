/**
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

#define N 3
class Solution
{
    vector<vector<int>> rows;
    vector<vector<int>> cols;
    vector<vector<int>> boxes;
    bool sudokuSolved;

    /**
 * 这个问题费了我很长时间, 主要是对于 字符越界问题, 更新记录的 细节出了错误
 * 
*/
public:
    void solveSudoku(vector<vector<char>> &board)
    {
        /// 后面会存储 1 - 9的索引, 所以开辟数组要大一些
        this->rows = vector(9, vector(10, 0));
        this->cols = vector(9, vector(10, 0));
        this->boxes = vector(9, vector(10, 0));
        this->sudokuSolved = false;

        // 预处理 , 更新初始化面板的数据
        for (int i = 0; i < 9; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                if (board[i][j] != '.')
                {
                    const char d = board[i][j];
                    // 1. 存储字符 '1' - '0' == 1
                    placeNumber(board, d - '0', i, j);
                }
            }
        }
        // 回溯
        backtrace(board, 0, 0);
        cout << "成功" << endl;
    }

    void backtrace(vector<vector<char>> &board, int row, int col)
    {
        if (board[row][col] != '.')
        {
            placeNextNumber(board, row, col);
        }
        else
        {
            // 放置 1 ~ 9
            for (int i = 1; i <= 9; i++)
            {
                // 先判断能不能放字符
                if (couldPlace(board, i, row, col))
                {
                    // 放字符, 并且更新记录
                    placeNumber(board, i, row, col);
                    board[row][col] = i + '0';
                    // 继续下一个位置, 这里可能会填充满
                    placeNextNumber(board, row, col);
                    // 所以要注意 解决的话就直接结束, 否则 恢复 一下, 以供下次尝试
                    if (!sudokuSolved)
                    {
                        removeNumber(board, i, row, col);
                    }
                }
            }
        }
    }

    void placeNumber(vector<vector<char>> &board, int d, int row, int col)
    {
        rows[row][d]++;
        cols[col][d]++;
        // 要点 : 注意 子数独的 索引
        int b_index = (row / 3) * 3 + col / 3;
        boxes[b_index][d]++;
    }

    void placeNextNumber(vector<vector<char>> &board, int row, int col)
    {
        // 终止条件
        if (row == 8 && col == 8)
        {
            sudokuSolved = true;
        }
        else if (col == 8)
        { // 注意这里的数据 上次错了
            backtrace(board, row + 1, 0);
        }
        else
        {
            backtrace(board, row, col + 1);
        }
    }

    void removeNumber(vector<vector<char>> &board, int d, int row, int col)
    {
        rows[row][d]--;
        cols[col][d]--;
        int b_index = (row / 3) * 3 + col / 3;
        boxes[b_index][d]--;
        board[row][col] = '.';
    }

    bool couldPlace(vector<vector<char>> &board, int d, int row, int col)
    {
        int b_index = (row / 3) * 3 + col / 3;
        return rows[row][d] + cols[col][d] + boxes[b_index][d] == 0;
    }
};

/**
 *  启发式搜索 , 子数独 优化  想用 mostPriorityBox 获取, 但是mostPriorityBox 有问题
 *  这个启发式没做出来, 某个地方越界了
*/

/**
class Solution
{
    vector<vector<int>> rows;
    vector<vector<int>> cols;
    vector<vector<int>> boxes;
    vector<int> box_Count;
    int count;
    bool sudokuSolved;
public:
    void solveSudoku(vector<vector<char>> &board)
    {
        /// 后面会存储 1 - 9的索引, 所以开辟数组要大一些
        this->rows = vector(9, vector(10, 0));
        this->cols = vector(9, vector(10, 0));
        this->boxes = vector(9, vector(10, 0));
        this->box_Count = vector(9, 0);
        this->count = 0;
        this->sudokuSolved = false;

        // 预处理 , 更新初始化面板的数据
        for (int i = 0; i < 9; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                if (board[i][j] != '.')
                {
                    const char d = board[i][j];
                    // 1. 存储字符 '1' - '0' == 1
                    placeNumber(board, d - '0', i, j);
                }
            }
        }
        // 找最优的数据
        // 回溯
        int boxIndex = mostPriorityBox();
        // 获取指定索引
        int row = 0;
        int col = 0;
        boxStartIndex(boxIndex, row, col);
        backtrace(board, row, col, boxIndex);
        cout << "成功" << endl;
    }

    int mostPriorityBox()
    {
        int most = 0;
        for (int i = 0; i < 9; i++)
        {
            if (box_Count[i] == 9){
                continue;
            }
            if (box_Count[most] == 9 || box_Count[i] > box_Count[most])
            {
                most = i;
            } 
        }
        return most;
    }

    void boxStartIndex(int idx, int &row, int &col)
    {
        col = idx % 3 * 3;
        row = idx / 3 * 3;
    }

    void boxEndIndex(int idx, int &row, int &col)
    {
        col = idx % 3 * 3 + 2;
        row = idx / 3 * 3 + 2;
    }

    void backtrace(vector<vector<char>> &board, int row, int col, int box_idx)
    {
        if (board[row][col] != '.')
        {
            placeNextNumber(board, row, col, box_idx);
        }
        else
        {
            // 放置 1 ~ 9
            for (int i = 1; i <= 9; i++)
            {
                // 先判断能不能放字符
                if (couldPlace(board, i, row, col))
                {
                    // 放字符, 并且更新记录
                    placeNumber(board, i, row, col);
                    board[row][col] = i + '0';
                    // 继续下一个位置, 这里可能会填充满
                    placeNextNumber(board, row, col, box_idx);
                    // 所以要注意 解决的话就直接结束, 否则 恢复 一下, 以供下次尝试
                    if (!sudokuSolved)
                    {
                        removeNumber(board, i, row, col);
                    }
                }
            }
        }
    }

    void placeNumber(vector<vector<char>> &board, int d, int row, int col)
    {
        rows[row][d]++;
        cols[col][d]++;
        // 要点 : 注意 子数独的 索引
        int b_index = (row / 3) * 3 + col / 3;
        boxes[b_index][d]++;
        box_Count[b_index]++;
        if (box_Count[b_index] == 9)
        {
            count++;
        }
    }

    void placeNextNumber(vector<vector<char>> &board, int row, int col, int box_idx)
    {
        // 终止条件
        if (count == 9)
        {
            sudokuSolved = true;
        }
        else
        {
            int e_r = 0, e_c = 0;
            boxEndIndex(box_idx, e_r, e_c);
            if (row == e_r && col == e_c)
            {
                box_idx = mostPriorityBox();
                boxStartIndex(e_r, e_c, box_idx);
                backtrace(board, e_r, e_c, box_idx);
            }
            else if (col == e_c)
            {
                backtrace(board, row + 1, e_c - 2, box_idx);
            }
            else
            {
                backtrace(board, row, col + 1, box_idx);
            }
        }
    }

    void removeNumber(vector<vector<char>> &board, int d, int row, int col)
    {
        rows[row][d]--;
        cols[col][d]--;
        int b_index = (row / 3) * 3 + col / 3;
        boxes[b_index][d]--;
        board[row][col] = '.';
        if (box_Count[b_index] == 9)
        {
            count--;
        }
        box_Count[b_index]--;
    }

    bool couldPlace(vector<vector<char>> &board, int d, int row, int col)
    {
        int b_index = (row / 3) * 3 + col / 3;
        return rows[row][d] + cols[col][d] + boxes[b_index][d] == 0;
    }
};
*/