class Solution:
    def rotate(self, nums: list, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None:
            return None
        length = len(nums)
        if length > 1:
            remainder = k % length
            self.reverse(nums, 0, length - 1)
            self.reverse(nums, 0, remainder - 1)
            self.reverse(nums, remainder, length - 1)

    def reverse(self, nums: list, begin: int, end: int) -> list:
        while begin < end:
            temp = nums[begin]
            nums[begin] = nums[end]
            nums[end] = temp
            begin = begin + 1
            end = end - 1
