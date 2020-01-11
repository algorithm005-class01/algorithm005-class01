#假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
#
# 你可以假设数组中不存在重复的元素。 
#
# 你的算法时间复杂度必须是 O(log n) 级别。 
#
# 示例 1: 
#
# 输入: nums = [4,5,6,7,0,1,2], target = 0
#输出: 4
# 
#
# 示例 2: 
#
# 输入: nums = [4,5,6,7,0,1,2], target = 3
#输出: -1
# Related Topics 数组 二分查找


from typing import List
#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 先找到旋转的点
        if not nums:
            return -1
        point, rotate = nums[0], -1
        for i in range(1, len(nums)):
            if nums[i] < point:
                rotate = i
                break
        if rotate == -1:
            return self.binary_search(nums, target)

        # 分别在左或者右边进行二分查找
        if target == nums[rotate]:
            return rotate
        if target <= nums[-1]:
            p = self.binary_search(nums[rotate + 1:], target)
            return p + 1 + rotate if p != -1 else -1
        else:
            return self.binary_search(nums[:rotate], target)

    def binary_search(self, arr, target):
        left, right = 0, len(arr) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target == arr[mid]:
                return mid
            if target > arr[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return -1
#leetcode submit region end(Prohibit modification and deletion)

print(Solution().search([1, 3], 2))
print(Solution().search([1, 3], 1))
print(Solution().search([1, 3], 3))
print(Solution().search([7, 8, 9, 0, 1, 2, 3, 4, 5,6], 4))