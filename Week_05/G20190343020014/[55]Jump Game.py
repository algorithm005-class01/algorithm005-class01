# 给定一个非负整数数组，你最初位于数组的第一个位置。
#
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
#
# 判断你是否能够到达最后一个位置。
#
# 示例 1:
#
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
#
#
# 示例 2:
#
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
#
# Related Topics 贪心算法 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        dp = [None for _ in range(len(nums))]
        dp[0] = True
        for i in range(1, len(nums)):
            for j in range(i):
                if dp[j] and nums[j] + j >= i:
                    dp[i] = True
                    break
        print(dp)
        return dp[-1]

    def canJump(self, nums):
        """自底向下的"""
        n = len(nums)
        dp = [None for _ in range(n)]
        dp[-1] = True
        for i in range(n - 2, -1, -1):
            jump = min(nums[i] + i, n - 1)
            for j in range(i + 1, jump + 1):
                if dp[j] is True:
                    dp[i] = True
                    break
        return dp[0]

    def canJump(self, nums):
        n = len(nums)
        last_position = n - 1
        for i in range(n - 1, -1, -1):
            print(i, i + nums[i], last_position)
            if i + nums[i] >= last_position:
                last_position = i

        return last_position == 0


# leetcode submit region end(Prohibit modification and deletion)

# assert Solution().canJump([2, 3, 1, 1, 4]) is True
assert Solution().canJump([3, 2, 1, 0, 4]) is False
