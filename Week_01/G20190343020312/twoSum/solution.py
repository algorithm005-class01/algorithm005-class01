#class Solution: 
#    def twoSum(self, nums, target):
#        for i in range(1,len(nums)):
#            if target - nums[i] in nums[:i]:
#                j = nums[:i].index(target - nums[i])
#                break
#        if j >= 0:
#            return [j, i]
class Solution:
    def twoSum(self, nums, target):
        k = 0
        for i in nums:
            k = k + 1
            if target - i in nums[k:]:
                return [k-1, nums[:].index(target - i)]
