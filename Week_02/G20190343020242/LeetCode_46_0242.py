#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#
# https://leetcode-cn.com/problems/permutations/description/
#
# algorithms
# Medium (72.95%)
# Likes:    475
# Dislikes: 0
# Total Accepted:    63.6K
# Total Submissions: 87.1K
# Testcase Example:  '[1,2,3]'
#
# 给定一个没有重复数字的序列，返回其所有可能的全排列。
#
# 示例:
#
# 输入: [1,2,3]
# 输出:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
#
#


# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # # 1. 内置方法
        # from itertools import permutations
        # return list(permutations(nums))

        # # 2. 回溯法
        # # 每次递归都需要传入参数 nums\tmp ，需要消耗额外的空间
        # # 以此确定每一位的元素
        # # nums 表示待加入的列表元素， tmp 表示已排列的元素
        # # for 循环一次将 nums 中元素添加到 tmp 中，[1,2,3]

        # res = []

        # def backtrack(nums, tmp):
        #     if not nums:
        #         res.append(tmp)
        #         return
        #     for i in range(len(nums)):
        #         backtrack(nums[:i] + nums[i + 1:], tmp + [nums[i]])
        #         # 将 nums 中的元素移动到 tmp 中

        # backtrack(nums, [])
        # return res

        # 3.回溯法
        # 每次递归都是在 nums 上就地修改，无需额外的空间
        n = len(nums)
        res = []

        def backtrack(first=0):
            if first == n:
                res.append(nums[:])
            for i in range(first, n):
                nums[first], nums[i] = nums[i], nums[first]
                backtrack(first + 1)
                nums[first], nums[i] = nums[i], nums[first]
                # 将 nums 复原，留待循环的下一次

        backtrack()
        return res


# @lc code=end