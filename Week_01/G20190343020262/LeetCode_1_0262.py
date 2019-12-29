def twoSum(self, nums: List[int], target: int) -> List[int]:
    dic = {}
        num = len(nums)
        for x in range(0,num):
            if nums[x] in dic:
                return [dic[nums[x]],x]
            else:
                dic[target-nums[x]]=x    
