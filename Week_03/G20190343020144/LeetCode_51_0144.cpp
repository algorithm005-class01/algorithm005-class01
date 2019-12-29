/**
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
 * 
*/

#include <vector>
#include <iosteam>
using namespace std;

/**
 * 结果:
执行用时 :8 ms, 在所有 cpp 提交中击败了91.90%的用户
内存消耗 :10.2 MB, 在所有 cpp 提交中击败了64.02%的用户
 * **/
class SolutionBacktrack {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<int> qRows;
        vector<vector<string>> ans;
        vector<string> path;
        solveNQueens(n,0,qRows,path,ans);
        return ans;
    }

    void solveNQueens(int n, int c_row, vector<int> &qRows, vector<string> &path, vector<vector<string>> &ans) {
        if (c_row == n) {
            ans.push_back(path);
            return;
        }

        // 遍历行
        // 记录行 比如 [1,3] 即 [0,1] 和 [1,3] 处包含 Q
        // 遍历列
            for (int col = 0; col < n ; col++){
                // 该位置是否可以填充皇后,
                // ① 该行前面没有填充 肯定没有
                // ② 该列前面没有填充  遍历 qRows
                bool contains1 = find(qRows.begin(),qRows.end(),col) != qRows.end();
                // ③ 该对角线 \ 没有填充 对角线 斜率是一致的(y=x或者-x) 即作差是否相等 或者 相反; 此处为相等
                // 四 该对角线 / 没有填充 此处相反
                if (contains1 || diagonalContains(qRows,c_row,col)) continue;
                // 填充记录
                qRows.push_back(col);
                // 生成 当前行的 string
                path.push_back(buildQ(n,col));
                solveNQueens(n,c_row + 1,qRows,path,ans);
                // reset
                qRows.pop_back();
                path.pop_back();
            }
    }

    bool diagonalContains(vector<int> &qRows,int c_row,int c_col) {
        bool c = false;
        for (int i = 0; i < qRows.size(); i++) {
            bool f1 = (i - c_row) == (qRows[i] - c_col);
            bool f2 = (i - c_row) == (c_col - qRows[i]);
            if (f1 || f2) {
                c = true;
                break;
            }
        }
        return c;
    }

    string buildQ(int n,int col){
        string q = "";
        for (int i =0;i<n;i++){
            q += i == col ? 'Q' : '.';
        }
        return q;
    }
};


int main ()
{
    vector<vector<string>> ret = Solution().solveNQueens(8);
    return -1;
}
