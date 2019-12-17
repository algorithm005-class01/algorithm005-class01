class Solution(object):

    def removeDuplicates(self, nums: list) -> int:
        if nums is None or len(nums) < 2:
            return len(nums)
        length = len(nums)
        index = 0
        for i in range(1, length):
            if nums[index] != nums[i]:
                index = index + 1
                nums[index] = nums[i]
            else:
                pass
        return index + 1