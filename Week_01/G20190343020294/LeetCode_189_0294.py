#给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
#输出: [5,6,7,1,2,3,4]
#解释:
#向右旋转 1 步: [7,1,2,3,4,5,6]
#向右旋转 2 步: [6,7,1,2,3,4,5]
#向右旋转 3 步: [5,6,7,1,2,3,4]
#
#
# 示例 2:
#
# 输入: [-1,-100,3,99] 和 k = 2
#输出: [3,99,-1,-100]
#解释:
#向右旋转 1 步: [99,-1,-100,3]
#向右旋转 2 步: [3,99,-1,-100]
#
# 说明:
#
#
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
# 要求使用空间复杂度为 O(1) 的 原地 算法。
#
# Related Topics 数组



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 1. 暴力：两次for，0-k次, 每次挪动一个位置 O(n^2)
        # 2. 保存前k个元素到k1，把k以后的元素挪到0~位置，k1放到后面 O(n)  O(n)
        # 3. 使用相同大小的新数组， 遍历每个元素放到新数组的i+k % len位置

        # 1.
        # if len(nums) == 0:
        #     return

        # for i in range(k):
        #     t = nums[-1]
        #     for j in range(0, len(nums)):
        #          temp = nums[j]
        #          nums[j] = t
        #          t = temp

        # 3
        # new_nums = list(nums)
        # for i in range(0, len(nums)):
        #     new_nums[(i+k)%len(nums)] = nums[i]

        # for i in range(0, len(nums)):
        #     nums[i] = new_nums[i]

        # 反转
        k = k % len(nums)
        self.reserve(nums, 0, len(nums) - 1)
        self.reserve(nums, 0, k - 1)
        self.reserve(nums, k, len(nums) - 1)

    def reserve(self, nums, s, e):
        while s < e:
            temp = nums[s]
            nums[s] = nums[e]
            nums[e] = temp
            s += 1
            e -= 1