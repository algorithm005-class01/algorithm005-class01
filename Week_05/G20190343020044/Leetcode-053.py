class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        length = len(nums)
        temp = nums[0]
        maxsum = temp
        for i in range(1, length):
            temp = temp + nums[i] if temp > 0 else nums[i]
            maxsum = max(temp, maxsum)
        return maxsum