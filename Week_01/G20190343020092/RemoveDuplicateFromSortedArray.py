class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        
        point1 = 0
        for point2 in range(1, len(nums)):
            if nums[point1] != nums[point2]:
                point1 += 1
                nums[point1] = nums[point2] #保证数组中，索引为point1及以前的元素，都是不重复
        return point1 +1
