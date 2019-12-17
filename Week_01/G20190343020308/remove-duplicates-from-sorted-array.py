class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        length = len(nums);
        if length == 0:
            return 0
        try:
            for i in range(0,length-1):
                temp = nums[i];
                while temp == nums[i+1]:
                    del nums[i];
                    
            
        except IndexError:
                pass

        return len(nums);