# 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
#
# 示例 1:
#
# 输入: [2,3,-2,4]
# 输出: 6
# 解释: 子数组 [2,3] 有最大乘积 6。
#
#
# 示例 2:
#
# 输入: [-2,0,-1]
# 输出: 0
# 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def maxProduct(self, nums):
        dpmin = dpmax = [0] * len(nums)
        maxv = dpmax[0] = dpmin[0] = nums[0]
        for i in range(1, len(nums)):
            dpmax[i] = max(dpmin[i - 1] * nums[i], max(dpmax[i - 1] * nums[i], nums[i]))
            dpmin[i] = min(dpmin[i - 1] * nums[i], min(dpmax[i - 1] * nums[i], nums[i]))
            maxv = max(dpmax[i], maxv)
        print(dpmax, maxv)
        print(dpmin)
        print("*" * 30)

    def maxProduct1(self, nums):
        mi = ma = nums[0]
        maxv = 0
        for i in range(1, len(nums)):
            if nums[i] < 0:
                mi, ma = ma, mi
            mi = min(mi * nums[i], nums[i])
            ma = max(ma * nums[i], nums[i])
            maxv = max(maxv, ma)
        print(maxv)


# leetcode submit region end(Prohibit modification and deletion)

Solution().maxProduct([2, 3, -2, 4])  # 6
Solution().maxProduct([-2, 0, -1])  # 0
Solution().maxProduct([0, 2])  # 2
Solution().maxProduct([-2, 3, -4])  # 24
Solution().maxProduct([3, -1, 4])  # 4
Solution().maxProduct([3, -1, 4, -1])  # 12
