#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#
# https://leetcode-cn.com/problems/counting-bits/description/
#
# algorithms
# Medium (73.73%)
# Likes:    223
# Dislikes: 0
# Total Accepted:    24.4K
# Total Submissions: 32.9K
# Testcase Example:  '2'
#
# 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
#
# 示例 1:
#
# 输入: 2
# 输出: [0,1,1]
#
# 示例 2:
#
# 输入: 5
# 输出: [0,1,1,2,1,2]
#
# 进阶:
#
#
# 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
# 要求算法的空间复杂度为O(n)。
# 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
#
#
#
from typing import List


# @lc code=start
class Solution:

    def countBits_1(self, num: int) -> List[int]:
        # 1. x 只比 x//2（i>>1）多最后一位；x 的最后一位通过其奇偶性（i&1）判断
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            ans[i] = ans[i >> 1] + (i & 1)
        return ans

    def countBits(self, num: int) -> List[int]:
        # 2. x&(x-1) 将 x 的最后一个1置为0
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            ans[i] = ans[i & (i - 1)] + 1
        return ans


# @lc code=end
