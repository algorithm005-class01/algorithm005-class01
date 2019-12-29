class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return nums[0]
        x = len(nums)/2
        d = {}
        for i in nums:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i] += 1
                if d[i] >= x:
                    return i