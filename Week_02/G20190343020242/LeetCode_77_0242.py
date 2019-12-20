#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (71.43%)
# Likes:    187
# Dislikes: 0
# Total Accepted:    27.6K
# Total Submissions: 38.4K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
#
#


# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # 1. 内置方法
        # from itertools import combinations
        # return list(combinations(range(1, n + 1), k))

        # 2. 递归：
        # TODO: 时间复杂度
        res = []

        def backtrack(first=1, curr=[]):
            if len(curr) == k:
                res.append(curr[:])
            for i in range(first, n + 1):
                curr.append(i)
                backtrack(i + 1, curr)
                curr.pop()
                # 复原 curr ,保证同一层循环的 curr 相同

        backtrack()
        return res


# @lc code=end
