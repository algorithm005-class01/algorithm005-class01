# 26. Remove Duplicates from Sorted Array

# Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

# Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

# Example 1:

# Given nums = [1,1,2],

# Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

# It doesn't matter what you leave beyond the returned length.
# Example 2:

# Given nums = [0,0,1,1,1,2,2,3,3,4],

# Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

# It doesn't matter what values are set beyond the returned length.

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1
        
        # 不要出现这种 p q i 三个指针跑的情况，直接搞懵逼了，一般这种情况有一个指针应该可以直接用 for 循环的 index 表示
        
        # n = len(nums)
        # if n == 0:
        #     return 0
        # p = 0
        # q = 1
        # for i in range(n):
        #     if q >= n:
        #         break
        #     if nums[p] == nums[q]:
        #         q += 1
        #     else:
        #         nums[p+1] = nums[q]
        #         p += 1
        # return p + 1

