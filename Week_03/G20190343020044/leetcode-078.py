class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        if len(nums) == 0:
            res.append([])
        else:
            subnum = nums[1:]
            for e in self.subsets(subnum):
                res.append(e)
                res.append([nums[0]]+e)
        return res