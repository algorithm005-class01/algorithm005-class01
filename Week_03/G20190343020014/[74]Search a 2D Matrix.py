#编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
#
# 
# 每行中的整数从左到右按升序排列。 
# 每行的第一个整数大于前一行的最后一个整数。 
# 
#
# 示例 1: 
#
# 输入:
#matrix = [
#  [1,   3,  5,  7],
#  [10, 11, 16, 20],
#  [23, 30, 34, 50]
#]
#target = 3
#输出: true
# 
#
# 示例 2: 
#
# 输入:
#matrix = [
#  [1,   3,  5,  7],
#  [10, 11, 16, 20],
#  [23, 30, 34, 50]
#]
#target = 13
#输出: false 
# Related Topics 数组 二分查找


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return False
        nums = []
        for i in matrix:
            nums += i
        return self.binary_search(nums, target)

    def binary_search(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return True
            if target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return False

    # 不使用额外的空间
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # matrix 拉长后， 每个点的坐标位置
        # row = idx//n, col = idx % n, n = len(matrix[0]]
        if not matrix: return False

        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        while left <= right:
            mid = left + (right - left) // 2
            # 计算矩阵的中间点
            row, col = mid//n, mid % n
            current = matrix[row][col]
            if target == current:
                # print(row, col)
                return True
            if target > current:
                left = mid + 1
            else:
                right = mid - 1
        return False


#leetcode submit region end(Prohibit modification and deletion)

matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

print(Solution().searchMatrix(matrix, 11))
print(Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,50]], 3))
# for i in range(12):
#     print(i // 4, i % 4)