class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(nums, [], res)
        return res

    def dfs(self, nums, path, res):
        if len(nums) == 0:
            return

        # terminator
        if not nums:
            res.append(path)
            return
        for i, n in enumerate(nums):
            self.dfs(nums[:i] + nums[i + 1:], path + [n], res)
