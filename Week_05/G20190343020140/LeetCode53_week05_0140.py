#解法1：贪心算法，该算法通用且简单：遍历数组并在每个步骤中更新：
#当前元素
#当前元素位置的最大和
#迄今为止的最大和该算法通用且简单：遍历数组并在每个步骤中更新：

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        cur_sum = max_sum = nums[0]
        for i in range(1,n):
            cur_sum = max(nums[i],cur_sum + nums[i])
            max_sum = max(cur_sum,max_sum)
        return max_sum

#解法2：DP 动态规划的是首先对数组进行遍历
#如果 nums[i] > 0，则说明 sum 对结果有增益效果，则 nums[i-1] 保留并加上当前遍历数字
#如果 nums[i] <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 nums[i] 直接更新为当前遍历数字
#最后取nums的最大值，遍历结束返回结果

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        for i in range(1,n):
            
            nums[i] += max(nums[i-1],0)
            
        return max(nums)

#解法3：分治算法，当最大子数组有 n 个数字时：

#终止条件：若 left >right，返回负数。
#left 为最大子数组前 n/2 个元素，在索引为 (left + right) // 2 的元素属于左子数组。
#right 为最大子数组的右子数组，为最后 n//2 的元素。
#第三组是包含左右子数组且含索引 (left + right) //2 的最大值。
#合并结果求醉倒值

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums,0,len(nums) - 1)
    
    def helper(self,nums,left,right):
        if left > right:
            return -2147483647
        mid = (left + right)//2
        left_max = sumNum = 0
        for i in range(mid-1,left-1,-1):
            sumNum += nums[i]
            left_max = max(left_max,sumNum)
        
        right_max = sumNum = 0
        for i in range(mid+1,right+1):
            sumNum += nums[i]
            right_max = max(right_max,sumNum)

        leftAns = self.helper(nums,left,mid-1)
        rightAns = self.helper(nums,mid +1,right)

        return max(left_max + nums[mid] +right_max,max(leftAns,rightAns))
