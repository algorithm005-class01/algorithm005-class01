from typing import List


class Solution(object):

    def majorityElement(self, nums: List[int]) -> int:
        return self.majorityElementRec(0, len(nums) - 1, nums)

    def majorityElementRec(self, lo: int, hi:int, nums: List[int]) -> int:
        if lo == hi:
            return nums[lo]

        mid = (hi - lo) // 2 + lo
        left = self.majorityElementRec(lo, mid, nums)
        right = self.majorityElementRec(mid + 1, hi, nums)

        if left == right:
            return left
        left_count = sum(1 for i in range(lo, hi + 1) if nums[i] == left)
        right_count = sum(1 for i in range(lo, hi + 1) if nums[i] == right)

        return left if left_count > right_count else right

if __name__ == '__main__':
    solution = Solution()

    nums = [2,3,1,3,1,2,3,3,4,5]
    print(solution.majorityElement(nums))


