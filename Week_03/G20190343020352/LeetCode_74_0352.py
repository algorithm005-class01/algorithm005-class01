from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) < 1 or matrix == [[]]:
            return False
        nums = []
        for i in range(len(matrix)):
            nums += matrix[i]
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == nums[mid]:
                return True
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return False


if __name__ == '__main__':
    solution = Solution()
    matrix = [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]
    print(solution.searchMatrix([[1]], 13))