#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
# https://leetcode-cn.com/problems/n-queens/description/
#
# algorithms
# Hard (66.89%)
# Likes:    289
# Dislikes: 0
# Total Accepted:    21.1K
# Total Submissions: 31.5K
# Testcase Example:  '4'
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
#
#
# 上图为 8 皇后问题的一种解法。
#
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
#
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
#
# 示例:
#
# 输入: 4
# 输出: [
# ⁠[".Q..",  // 解法 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
#
# ⁠["..Q.",  // 解法 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
#
#
#

from typing import List

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # TODO:时间复杂度 O(N!)，空间复杂度 O(N)
        def could_place(row, col):
            return not (cols[col] + hill_diagonals[row - col] +
                        dale_diagonals[row + col])

        def place_queen(row, col):
            queens.add((row, col))
            cols[col] = 1                   # 第 col 列在攻击范围
            hill_diagonals[row - col] = 1   # 从左到右对角线 在攻击范围
            dale_diagonals[row + col] = 1   # 从右到左对角线 在攻击范围

        def remove_queen(row, col):
            queens.remove((row, col))
            cols[col] = 0
            hill_diagonals[row - col] = 0
            dale_diagonals[row + col] = 0

        def add_solution():
            solution = []
            for _, col in sorted(queens):
                solution.append('.' * col + 'Q' + '.' * (n - col - 1))
            output.append(solution)

        def backtrack(row=0):
            for col in range(n):
                if could_place(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        add_solution()
                    else:
                        backtrack(row + 1)  # 深入下一行，继承了上一行的 cols\hill\dale 数据
                    remove_queen(row, col)  # 状态复原，然后继续循环，在下一列 放置皇后

        cols = [0] * n
        hill_diagonals = [0] * (2 * n - 1)
        dale_diagonals = [0] * (2 * n - 1)
        queens = set()
        output = []
        backtrack()
        return output

        # TODO: 2. Bitmap 的使用



# @lc code=end


res = Solution().solveNQueens(4)
print(res)