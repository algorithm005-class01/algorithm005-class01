#解法1：迭代法，总的集合 = 上一子集 + 上一子集中每个子集插入新元素
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        for i in nums:
            res += [[i] +num for num in res]
        return res

#解法2 递归法 helper 是上一子集中每个子集插入新元素，有回溯，res中存了所有子集的结果
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        n = len(nums)
        def helper(i,temp):
            res.append(temp)
            for j in range(i,n):
                helper(j+1,temp+[nums[j]])
        helper(0,[])
        return res
