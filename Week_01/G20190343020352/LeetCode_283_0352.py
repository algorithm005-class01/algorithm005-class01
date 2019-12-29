class Solution:

    def moveZeroes(self, nums: list) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums) == 1:
            return nums
        length = len(nums)
        index = 0
        for i in range(0, length):
            if nums[i] != 0:
                nums[index] = nums[i]
                if (i != index):
                    nums[i] = 0
                index = index + 1
        return nums