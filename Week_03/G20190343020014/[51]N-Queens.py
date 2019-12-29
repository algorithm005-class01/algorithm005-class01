#n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
#
# 
#
# 上图为 8 皇后问题的一种解法。 
#
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
#
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
#
# 示例: 
#
# 输入: 4
#输出: [
# [".Q..",  // 解法 1
#  "...Q",
#  "Q...",
#  "..Q."],
#
# ["..Q.",  // 解法 2
#  "Q...",
#  "...Q",
#  ".Q.."]
#]
#解释: 4 皇后问题存在两个不同的解法。
# 
# Related Topics 回溯算法


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        def backtrace(board, row):
            # 如果满足条件-添加结果， row==n 表示走到棋盘最后
            if row == n:
                res.append(self.get_result(board))
                return
            for col in range(n):
                # 排除不合法选择
                if not self.is_ok(board, row, col):
                    continue
                # 选择
                board[row][col] = 'Q'
                # 进入下一层决策
                backtrace(board, row + 1)
                # 撤销
                board[row][col] = '.'

        res = []
        # 初始化一个n x n 的棋盘
        b = [['.' for _ in range(n)] for _ in range(n)]
        backtrace(b, 0)
        return res

    def is_ok(self, board, row, col):
        """ 检查当前放置位置是否可行
            当前位置的横纵、对角线不能有皇后
        """
        # # 横向检查是否有Q  （回溯方法体是从row开始， 尝试放置Q）
        # for x in range(n):
        #     if board[row][x] == 'Q':
        #         return False
        # 纵向检查列
        n = len(board)
        for y in range(n):
            if board[y][col] == 'Q':
                return False

        # 对脚线-左上角和右上角

        # 左上
        x, y = row - 1, col - 1
        while x >= 0 and y >= 0:
            if board[x][y] == 'Q':
                return False
            x -= 1
            y -= 1

        # 右上
        x, y = row - 1, col + 1
        while x >= 0 and y < n:
            if board[x][y] == 'Q':
                return False
            x -= 1
            y += 1

        return True

    def get_result(self, res):
        return [''.join(row) for row in res]

#leetcode submit region end(Prohibit modification and deletion)
x = Solution().solveNQueens(0)
print(x)