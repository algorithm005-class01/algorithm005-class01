from typing import List
class Solution:
    def removeDuplicates(self,nums: List[int]) -> int:
        """
        :type nums: List[int]
        :rtype int
        """
        #if not nums:
        #    return 0
        #j = 0
        #for i in range(1,len(nums)):
        #    if nums[j] != nums[i]:
        #        j = j + 1
        #        nums[j] = nums[i]
        #return j + 1 
        i = 0
        while i < len(nums):
            while i + 1 <= len(nums) - 1 and nums[i+1] == nums[i]:
                #nums.remove(nums[i+1])
                del nums[i+1]
            i = i + 1
        return len(nums)
