#解法1 遍历一次+判断
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, v in enumerate(nums):
            if (target - v) in nums[i+1:]:
                return i,nums[i+1:].index(target-v)+i+1

#解法2 哈希表映射
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i, v in enumerate(nums):
            if v not in d:
                d[target-v] = i
            else:
                return [d[v],i]
