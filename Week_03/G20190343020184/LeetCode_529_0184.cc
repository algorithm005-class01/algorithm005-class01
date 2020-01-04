#include <iostream>
#include <vector>

using namespace std;

//这个题是真的弱智了。。。。
//按照题意dfs就行了，我自己还发挥了一把，结果写了两小时没结果。
class Solution
{
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click)
    {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else
            dfs(board, x, y);
        return board;
    }

    void dfs(vector<vector<char>>& board, int x, int y)
    {
        if (isValid(x, y, board) == false)
            return;
        else if (board[x][y] == 'E')
        {
            vector<vector<int> > surr = { { -1,0 },{ -1,-1 },{ -1,1 },{ 1,0 },{ 1,-1 },{ 1,1 },{ 0,-1 },{ 0,1 } };
            int count = 0;
            for (vector<int> i : surr)
            {
                int x1 = x + i[0], y1 = y + i[1];
                if (isValid(x1, y1, board) == true && board[x1][y1] == 'M')
                    count++;
            }

            if (count >= 1)
            {
                board[x][y] = '0' + count;
                return;
            }
            else
            {
                board[x][y] = 'B';
                for (vector<int> i : surr)
                {
                    int x1 = x + i[0], y1 = y + i[1];
                    dfs(board, x1, y1);
                }
            }
        }
    }

    bool isValid(int x, int y, vector<vector<char>>& board)
    {
        int row = board.size(), col = board[0].size();
        if (x < 0 || x >= row || y < 0 || y >= col)
            return false;
        else
            return true;
    }
};


int main(int argc, char *argv[])
{
	Solution A;
	return 0;
}
