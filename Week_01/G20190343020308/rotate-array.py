class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        for i in range(k):
            # temp = nums.pop()
            nums.insert(0,nums.pop())
          

        return nums