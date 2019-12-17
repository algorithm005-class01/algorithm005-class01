"""26. Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

    Given nums = [1,1,2],

    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

    It doesn't matter what you leave beyond the returned length.
"""

class Solution(object):
    def remove_duplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        我比较喜欢这种写法，没有采用传统的 old-style indexed looping，正好结合 python 的遍历形式，
        在遍历过程中，比较当前值是否大于前值，要与前值比较，当然至少要从第二个位置(如果有的话)开始，
        利用 i = int(len(nums) > 0) 的写法，可以省略对 i 的判断，直接定位出初始位置。对应空数组和只有一个
        元素的数组，i 值即为数组长度；对于长度大于 1 的数组，因为每次在前后值不等时，i 后移了一位，直接返回 i 的值即为
        有效数组长度
        """
        i = int(len(nums) > 0)
        for n in nums:
            if n > nums[i-1]:
                nums[i] = n
                i += 1
        return i

    def remove_duplicates2(self, nums):
        """双指针法

        固定 i, j 两个快慢指针
        当 nums[i] 和 nums[j] 相等时，快指针 j 往后移，此时慢指针 i 停留在重复值的第一个位置
        当 nums[i] 和 nums[j] 不等时，慢指针 i + 1，用 j 所在位置的值覆盖重复值，当然，在没
        有重复值的排序数组中，其实都是在做自我赋值。

        注意：题目要求返回【有效数组】长度，遍历结束时 i 需要加 1
        """
        i, j = 0, 1
        while j < len(nums):
            if nums[i] == nums[j]:
                j += 1
            else:
                i += 1
                nums[i] = nums[j]
                j += 1
        return i + 1
