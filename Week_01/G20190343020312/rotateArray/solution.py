# encoding:utf-8

class Solution:
    ##方法一
    def rotateArray(self, nums, k):
        i = 0
        list1 = [0 for j in range(len(nums))]
        for i in range(len(nums)):
            if i < len(nums) - k:
                list1[i+k] = nums[i]
            else:
                list1[(i+k)%len(nums)] = nums[i]
        return list1
    #方法二
    def rotateArray2(self,nums,k):
        n = len(nums)
        i = 0
        k = k % n
        while i < k:
            temp = nums[n-1]
            j = n - 1
            while j > 0:
                nums[j] = nums[j-1]
                j = j - 1
            nums[0] = temp
            i = i + 1
        return nums

