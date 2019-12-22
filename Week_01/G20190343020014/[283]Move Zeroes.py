class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 正向扫描，记录0的位置，把非0往前移动
        place = -1
        for i, n in enumerate(nums):
            if n == 0:
                if place == -1:
                    place = i 
            else:
                if place == -1:
                    continue
                else:
                    nums[place], nums[i] = n, 0
                    place += 1