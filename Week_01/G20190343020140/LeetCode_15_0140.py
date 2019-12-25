#解法一：排序 +双指针
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums and len(nums) < 3:
            return []
        
        nums.sort()
        if nums[0] > 0:
            return []

        res = []
        
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            L = i + 1
            R = len(nums) - 1

            while L < R:
                x = nums[L] + nums[R] + nums[i]
                if x == 0:
                    res.append([nums[L],nums[R],nums[i]])
                    while L < R and nums[L] == nums[L+1]:
                        L += 1
                    while L < R and nums[R] == nums[R-1]:
                        R -= 1
                    L += 1
                    R -= 1
            
                elif x > 0:
                    R -= 1
                else:
                    L += 1

        return res

#解法二：两次遍历+哈希表
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) < 3:
            return []
        
        nums.sort()

        res = set()
        
        for i, v in enumerate(nums[:-2]):
            if i >= 1 and v ==nums[i-1]:
                continue
            
            d = {}
            for x in nums[i+1:]:
                if x not in d:
                    d[-v-x] = 1
                else:
                    res.add((v,-v-x,x))
                

        return map(list,res)
