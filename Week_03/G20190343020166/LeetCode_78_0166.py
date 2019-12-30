"""78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
"""


class Solution(object):

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        首先初始化一个数组subsets，里面有一个坑位，然后遍历数组
        设想一只兔子从subsets第一个元素开始，依次跳过，将自己[n]与元素结合,
        并追加到 subsets中去，等待下一站兔子来

        例如：nums = [1,2,3]
        subsets = [[]]
        n=1: [[], [1]]
        n=2: [[], [1], [2], [1,2]]
        n=3: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
        """
        subsets = [[]]
        for n in nums:
            subsets += [[n] + s for s in subsets]
        return subsets

    def subsets_by_dfs(self, nums):
        res = []
        self.dfs(nums, 0, [], res)
        return res

    def dfs(self, nums, index, path, res):
        res.append(path)
        for i in xrange(index, len(nums)):
            self.dfs(nums, i + 1, path + [nums[i]])
