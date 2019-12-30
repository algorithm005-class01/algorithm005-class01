#解法1 排序，取中位数 
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        n = len(nums)
        if n % 2 == 1:
            index = int((n + 1)/2 -1)
        else:
            index =int(n/2)-1
        return nums[index]

#解法2 简化了解法1
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        n = len(nums)
        
        return nums[int(n/2)]

#解法3：摩尔投票法，多数的得票大于平均数，所以只要每次计算投票次数，是众数就+1，不是就-1，减到0，替换成当前元素
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        candidate = None
        
        for num in nums:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)
        return candidate

#解法4：分治法，分解成求子问题，但是对左右众数不是同样值的情况，要重新计算他们在list 中的个数，时间复杂度高于其他解法
class Solution(object):
    def majorityElement(self,nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        if len(nums) == 1:
            return nums[0]
        a = self.majorityElement(nums[:len(nums)//2])
        b = self.majorityElement(nums[len(nums)//2:])

        if a == b:
            return a
        return [b,a][nums.count(a) > len(nums)//2]
