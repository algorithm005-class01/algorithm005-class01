class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #定义一个变量存放下标，表明num[]中的该位置可以用于更新元素
        swapIndex = 0
        for i in range(len(nums)):
            if nums [i] != 0:#遍历到非0元素，两两交换第一个0元素与当前元素
                nums[i], nums[zeroIndex] = nums[zeroIndex], nums[i]
                swapIndex += 1
