class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(0,len(nums)-1):
            k = 0
            for j in range(i+1, len(nums)):
                if nums[i] == nums[j-k]:
                    nums.pop(j-k)
                    k = k + 1
        
        return len(nums)

