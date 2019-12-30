from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        if len(nums) < 1:
            return -1
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] >= nums[0] and (target < nums[0] or target > nums[mid]):
                left = mid + 1
            elif nums[0] > target > nums[mid]:
                left = mid + 1
            else:
                right = mid
        return left if left == right and nums[left] == target else -1


if __name__ == '__main__':
    solution = Solution()
    print(solution.search([1,3], 3))