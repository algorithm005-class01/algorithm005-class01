# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
#
# 请找出其中最小的元素。 
#
# 你可以假设数组中不存在重复元素。 
#
# 示例 1: 
#
# 输入: [3,4,5,1,2]
# 输出: 1
#
# 示例 2: 
#
# 输入: [4,5,6,7,0,1,2]
# 输出: 0
# Related Topics 数组 二分查找


from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        if len(nums) == 1:
            return nums[0]

        left, right = 0, len(nums) - 1

        # 如果nums[0] < nums[-1] 说明没有旋转点
        if nums[left] < nums[right]:
            return nums[left]

        while left <= right:
            mid = left + (right - left) // 2

            # 找到第一个开始下降的元素
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if mid > 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]

            # 这时旋转点可能落在， 大的一半， 也可能落在小的一半
            else:
                # 说明旋转点在后半部分分
                if nums[mid] > nums[left]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findMin([4, 5, 1, 2, 3]))
