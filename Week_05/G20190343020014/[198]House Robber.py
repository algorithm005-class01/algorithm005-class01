# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
#
# 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
#
# 示例 1:
#
# 输入: [1,2,3,1]
# 输出: 4
# 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
#      偷窃到的最高金额 = 1 + 3 = 4 。
#
# 示例 2:
#
# 输入: [2,7,9,3,1]
# 输出: 12
# 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
#      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
#
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def rob0(self, nums):
        """
        dp[i] 表示从0..i 能偷到的最大金额
        dp[i][不偷] = max(dp[i-1][偷], dp[i - 1][不偷])
        dp[i][偷] = dp[i - 1][不偷] + nums[i]

        """
        if not nums:
            return 0
        dp = [[0, 0] for _ in range(len(nums))]
        dp[0][0] = 0
        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            # 当前房子不偷
            dp[i][0] = max(dp[i - 1][0], dp[i-1][1])

            # 当前房子偷
            dp[i][1] = dp[i - 1][0] + nums[i]

        return max(dp[-1][0], dp[-1][1])

    def rob1(self, nums):
        """
        dp[i] 表示从0..i nums[i] 天必偷的结果,  能偷到的最大金额
            i-1 天不偷， i-2 天必偷
            dp[i] = max (dp[i-1] + 0,  dp[i - 2] + nums[i])
            dp[0] = num[0]
            dp[1] = max(num[0], num[1])
        """
        if not nums:
            return 0

        dp = [0] * nums
        dp[0], dp[1] = nums[0], max(nums[:2])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[-1]

    def rob2(self, nums):
        """
            dp数组可以用两个变量来替换
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        day1, day2 = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            day3 = max(day1 + nums[i], day2)
            day1, day2 = day2, day3

        return day2

    def rob3(self, nums):
        """
            dp数组可以用两个变量来替换
        """
        day1, day2 = 0, 0
        for i in nums:
            day3 = max(day1 + i, day2)
            day1, day2 = day2, day3

        return day2

    def rob4(self, nums):
        def dp(start):
            if start >= len(nums):
                return 0
            # 不偷, 去下一家
            m1 = dp(start + 1)
            # 偷， 去下下家
            m2 = dp(start + 2) + nums[start]
            return max(m1, m2)
        return dp(0)

    def rob5(self, nums):
        """递归+记忆化"""
        def dp(start, mem):
            if start >= len(nums):
                return 0
            if start in mem: return mem[start]
            # 不偷, 去下一家
            m1 = dp(start + 1, mem)
            # 偷， 去下下家
            m2 = dp(start + 2, mem) + nums[start]
            mem[start] = max(m1, m2)
            return mem[start]
        return dp(0, {})

    def rob6(self, nums):
        """递归+记忆化, 改写自底向上的写法"""

        n = len(nums)
        dp = [0] * (n + 2)
        for i in range(n - 1, -1, -1):
            dp[i] = max(dp[i + 1], dp[i + 2] + nums[i])
        return dp[0]

    def rob(self, nums):
        """
        递归+记忆化, 改写自底向上的写法
        优化为O(1) 空间
        """
        n = len(nums)
        dp_1, dp_2, dp = 0, 0, 0
        for i in range(n - 1, -1, -1):
            dp = max(dp_1, dp_2 + nums[i])
            dp_2 = dp_1
            dp_1 = dp
        return dp


# leetcode submit region end(Prohibit modification and deletion)
assert Solution().rob([1, 2, 3, 1]) == 4
assert Solution().rob([]) == 0
assert Solution().rob6([3, 1, 3, 100])
assert Solution().rob6([1, 3, 1, 3])
