"""283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
"""

class Solution(object):

    def move_zeroes(self, nums):
        """
        :type nums: List[int]
        :rtyp
        """
        zero = 0
        for i, n in enumerate(nums):
            if n == 0:
                continue
            nums[zero], nums[i] = nums[i], nums[zero]
            zero += 1

    def move_zeroes_by_snowball(self, nums):
        """雪球计数

        数值为 0 时，雪球数量加 1；数值不为 0 时，将当前位置的值赋值给第一个雪球位置, 当前位置赋值为 0
        """
        snowball_size = 0
        for i, n in enumerate(nums):
            if n == 0:
                snowball_size += 1
            else:
                nums[i], nums[i-snowball_size] = 0, n
