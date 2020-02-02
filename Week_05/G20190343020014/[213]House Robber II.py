# 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
#
# 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
#
# 示例 1:
#
# 输入: [2,3,2]
# 输出: 3
# 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
#
#
# 示例 2:
#
# 输入: [1,2,3,1]
# 输出: 4
# 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
#      偷窃到的最高金额 = 1 + 3 = 4 。
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def rob(self, nums):
        """
        因为是环， 第一间和第二间房子不能同时被偷
        情况1： 第一家偷了， 也就是偷 0, i-1 之间的最大金额
        情况2： 第一家不偷   也就是偷 1, i 之间的最大金额
        情况3： 第一和最后一家都不偷， 也就是偷 1, i-1 之间的最大金额
          情况三的选择一定小于情况1 和2， 所以我们只比较情况1，2 结构即可

        """

        def _rob(start, end):
            dp_i_1 = dp_i_2 = dp_i = 0
            i = end
            while i >= start:
                dp_i = max(dp_i_1, nums[i] + dp_i_2)
                dp_i_2 = dp_i_1
                dp_i_1 = dp_i
                i -= 1
            return dp_i

        return max(_rob(0, len(nums) - 2), _rob(1, len(nums) - 1))


# leetcode submit region end(Prohibit modification and deletion)
assert Solution().rob([2, 3, 2]) == 3
assert Solution().rob([]) == 0
assert Solution().rob([1, 2, 3, 1]) == 4
assert Solution().rob([1, 3, 1, 3, 100]) == 103
