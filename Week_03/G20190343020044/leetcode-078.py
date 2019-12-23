class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == []:
            return [[]]
        res = []
        for e in self.subsets(nums[1:]):
            res.append(e)
            res.append([nums[0]]+e)
        return res