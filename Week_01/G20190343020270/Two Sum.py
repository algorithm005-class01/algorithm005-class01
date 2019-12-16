# 1. Two Sum

# Given an array of integers, return indices of the two numbers such that they add up to a specific target.

# You may assume that each input would have exactly one solution, and you may not use the same element twice.

# Example:

# Given nums = [2, 7, 11, 15], target = 9,

# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # 暴力解法
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        
        # map
#         dic = {}
#         n = len(nums)
#         for i in range(n):
#             dic[nums[i]] = i
            
#         for j in range(n):
#             i = dic.get(target - nums[j])
#             if i and i != j:
#                 return [i, j]
            
        dic = {}
        for i, v in enumerate(nums):
            if dic.get(target-v) is not None:
                return [i, dic.get(target-v)]
            dic[v] = i 