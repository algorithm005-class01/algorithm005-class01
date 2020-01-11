class Solution(object):
    def can_jump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        farthest_index_possible = 0
        for i, n in enumerate(nums):
            if i > farthest_index_possible:
                return False
            farthest_index_possible = max(farthest_index_possible, i + n)
        return True

    def can_jump2(self, nums):
        """
        going back version
        """
        goal = len(nums) - 1
        for i in range(len(nums))[::-1]:
            if i + nums[i] >= goal:
                goal = i
        return goal == 0
