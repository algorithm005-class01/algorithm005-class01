#
# @lc app=leetcode.cn id=493 lang=python3
#
# [493] 翻转对
#
# https://leetcode-cn.com/problems/reverse-pairs/description/
#
# algorithms
# Hard (21.07%)
# Likes:    58
# Dislikes: 0
# Total Accepted:    2.5K
# Total Submissions: 11.5K
# Testcase Example:  '[1,3,2,3,1]'
#
# 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
#
# 你需要返回给定数组中的重要翻转对的数量。
#
# 示例 1:
#
#
# 输入: [1,3,2,3,1]
# 输出: 2
#
#
# 示例 2:
#
#
# 输入: [2,4,3,5,1]
# 输出: 3
#
#
# 注意:
#
#
# 给定数组的长度不会超过50000。
# 输入数组中的所有数字都在32位整数的表示范围内。
#
#
#
from typing import List


# @lc code=start
class Solution:

    def reversePairs_1(self, nums: List[int]) -> int:
        # 1. 超时！！！
        ans = 0
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] > 2 * nums[j]:
                    ans += 1
        return ans

    def reversePairs(self, nums: List[int]) -> int:
        # 2. 归并排序时计数翻转对

        self.ans = 0

        def merge_sort(nums):
            n = len(nums)
            if n < 2:
                return nums
            return merge(merge_sort(nums[:n // 2]), merge_sort(nums[n // 2:]))

        def merge(s1, s2):
            i, j = 0, 0
            while i < len(s1) and j < len(s2):
                if s1[i] <= 2 * s2[j]:
                    i += 1
                else:
                    self.ans += len(s1) - i     # s1,s2 递增；s1[i:] 所有元素都可以和 s2[j] 元素构成翻转对
                    j += 1
            return sorted(s1 + s2)     # 直接排序

        merge_sort(nums)
        return self.ans

    def reversePairs_2(self, nums: List[int]) -> int:
        # TODO:
        # 树状数组：Binary Indexed Tree
        new_nums = nums + [x*2 for x in nums]
        sorted_set = sorted(list(set(new_nums)))
        tree = BIT(len(sorted_set))
        res = 0
        ranks = {}
        for i, n in enumerate(sorted_set):
            ranks[n] = i+1
        
        for n in nums[::-1]:
            res += tree.query(ranks[n]-1)
            tree.update(ranks[n*2], 1)
        
        return res


class BIT:

    def __init__(self, n):
        self.n = n + 1
        self.sums = [0] * self.n

    def update(self, i, delta):
        while i < self.n:
            self.sums[i] += delta
            i += i & (-i)

    def query(self, i):
        res = 0
        while i > 0:
            res += self.sums[i]
            i -= i & (-i)
        return res


# @lc code=end

nums = [4, 5, 1, 2, 3]
print(Solution().reversePairs(nums))


# 树状数组
