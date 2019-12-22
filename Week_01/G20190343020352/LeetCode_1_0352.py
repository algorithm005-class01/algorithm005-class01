class Solution(object):

    def twoSum(self, nums: list, target: int) -> list:
        if nums is None:
            return None
        length = len(nums)
        if length == 1:
            return []
        hashMap = {}
        for i, num in enumerate(nums):
            key = hashMap.get(target - num)
            if key is not None:
                return [i, key]
            hashMap[num] = i
        return []