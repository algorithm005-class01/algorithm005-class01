class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        length = len(nums)
        if length == 0:
            return -1
        while low < high:
            mid = (high - low) // 2 + low
            if nums[mid] == target:
                return mid
            #如果[0,mid]是一个单调递增区间
            elif nums[0] <= nums[mid]:
                #并且target也在这个单调区间里
                if nums[low] <= target and target < nums[mid]:
                    high = mid -1
                else:
                    low = mid +1
            #如果[0,mid]不是一个单调递增区间
            else:
                #并且target在[mid,high]这个单调区间内
                if nums[mid] < target and target <= nums[high]: 
                    low = mid + 1
                else:
                    high = mid - 1
        return low if nums[low] == target else -1 
