#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#
# https://leetcode-cn.com/problems/search-a-2d-matrix/description/
#
# algorithms
# Medium (36.45%)
# Likes:    111
# Dislikes: 0
# Total Accepted:    25.2K
# Total Submissions: 68.9K
# Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
#
# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
#
#
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。
#
#
# 示例 1:
#
# 输入:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 3
# 输出: true
#
#
# 示例 2:
#
# 输入:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 13
# 输出: false
#
#


# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # # 1. 转化成列表：太慢太耗内存
        # if not any(matrix):
        #     return False

        # m, n = len(matrix), len(matrix[0])
        # nums = [None] * (m * n)
        # for i in range(m):
        #     nums[i * n:(i + 1) * n] = matrix[i]

        # left, right = 0, m * n - 1
        # while left <= right:
        #     mid = (left + right) // 2
        #     if nums[mid] == target:
        #         return True
        #     elif nums[mid] > target:
        #         right = mid - 1
        #     else:
        #         left = mid + 1
        # return False

        # 2. 将索引转化成二维索引
        if not any(matrix):
            return False

        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        while left <= right:
            mid = (left + right) // 2
            if matrix[mid//n][mid%n] == target:
                return True
            elif matrix[mid//n][mid%n] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False

        # TODO：3. 太慢太消耗内存



# @lc code=end



