class Solution:
    #使用字典存每个元素及其出现的次数
    #复杂度O(N),额外需要0(N)空间
    # def majorityElement(self, nums: List[int]) -> int:
    #     myDict = {}
    #     length = len(nums)
    #     if length == 1:
    #         return nums[0]
    #     for i in nums:
    #         if i in myDict:
    #             myDict[i] += 1
    #             if myDict[i] > length//2:
    #                 return i
    #         else:
    #             myDict[i] = 1

    #分治法，把问题切分成两个子问题：左半边的众数和右半边的众数
    #最小的子问题，也就是终止条件为：左/右半边的数组长度为1
    #复杂度o(NlogN)
    def majorityElement(self, nums: List[int]) -> int:

        def myHelper(low, high):
            #终止条件
            if low == high:
                return nums[low]
            #左右分治
            mid = (high - low) // 2 + low
            left = myHelper(low, mid)
            right = myHelper(mid+1, high)

            #合并结果
            if left == right:
                return left
            
            left_count = 0
            right_count = 0
            for i in range(low, high+1):
                if nums[i] == left:
                    left_count += 1
                elif nums[i] == right:
                    right_count += 1
            #上面几行可以简化成以下两段，但是会多for循环一次
            #left_count = sum(1 for i in range(low, high+1) if nums[i] == left)
            #right_count = sum(1 for i in range(low, high+1) if nums[i] == right)           
            return left if left_count > right_count else right
        low = 0
        high = len(nums) - 1
        return myHelper(low, high)


