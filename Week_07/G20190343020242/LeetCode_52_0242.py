#
# @lc app=leetcode.cn id=52 lang=python3
#
# [52] N皇后 II
#
# https://leetcode-cn.com/problems/n-queens-ii/description/
#
# algorithms
# Hard (76.27%)
# Likes:    93
# Dislikes: 0
# Total Accepted:    14.2K
# Total Submissions: 18.5K
# Testcase Example:  '4'
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
#
#
# 上图为 8 皇后问题的一种解法。
#
# 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
#
# 示例:
#
# 输入: 4
# 输出: 2
# 解释: 4 皇后问题存在如下两个不同的解法。
# [
# [".Q..",  // 解法 1
# "...Q",
# "Q...",
# "..Q."],
#
# ["..Q.",  // 解法 2
# "Q...",
# "...Q",
# ".Q.."]
# ]
#
#
#


# @lc code=start
class Solution:

    def totalNQueens(self, n: int) -> int:
        # 1. 位运算
        # TODO:
        if n < 1:
            return 0

        self.count = 0

        def dfs(row, cols, pie, na):
            if row >= n:
                self.count += 1
                return
            bits = (~(cols | pie | na)) & ((1 << n) - 1)     
            # ~(cols | pie | na) 得到 32 位中所有的空位，空位处为二进制 1 
            # ... & ((1 << n) - 1) 只保留最后 n 位
            while bits:
                p = bits & -bits     # 取得最低位的 1
                bits = bits & (bits - 1)     # 表示在 p 的位置放入皇后
                dfs(row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
                # cols|p 将 cols 第 p 位置为 1
                # (pie | p) << 1 
                # (na | p) >> 1) 

        dfs(0, 0, 0, 0)
        return self.count


# @lc code=end

class Solution2():
    # 不同的代码形式：
    def totalNQueens(self, n):
        self.res = 0
        self.dfs([-1] * n, 0)
        return self.res
    
    def dfs(self, nums, index):
        if index == len(nums):
            self.res += 1
            return
        for i in range(len(nums)):
            nums[index] = i
            if self.valid(nums, index):
                self.dfs(nums, index + 1)
    
    def valid(self, nums, n):
        for i in range(n):
            if nums[i] == nums[n] or abs(nums[n] - nums[i]) == n - i:
                # nums 数组表示每一行的皇后放在哪一列
                # nums[i] == nums[n] 表示不同行 i/n 的皇后在同一列
                # abs(nums[n] - nums[i]) == n - i 表示 y=x+k 或 y=-x+k两条对角线
                
                return False
        return True