#
# @lc app=leetcode.cn id=818 lang=python3
#
# [818] 赛车
#

# @lc code=start
class Solution:
    # https://leetcode.com/problems/race-car/discuss/124326/Summary-of-the-BFS-and-DP-solutions-with-intuitive-explanation
    # 这个把题目读明白已经是很有挑战的事
    # 注意位运算符运算优先级低于加减号
    # 状态定义 dp(i) 为走到位置i，需要的最少指令数
    # 分为三种情况 
    # 1.先走了a0个A，R(-1)，又回头走了b0个A，R(1) --> dp[i] = min(dp[i], a0+1+b0+1+dp[i-(a1-b1)])
    # 2.刚好a0个A与i相等 --> a0
    # 3.a0个A走的距离大于i，R(-1)，往回走b0个A --> dp[i] = min(dp[i], a0 + (0 if a1 == i else 1 + dp[a1-i]))
    # 最后再思考下base case的情况a0、a1、b0、b1
    # 时间复杂度O(n * (log(n))^2) 900ms
    def racecar(self, target: int) -> int:
        dp = [float('inf')] * (target+1)
        dp[0] = 0
        for i in range(1, target+1):
            a0, a1 = 1, 1
            while a1 < i:
                b0, b1 = 0, 0
                while b1 < a1:
                    dp[i] = min(dp[i], a0+1+b0+1+dp[i-(a1-b1)])
                    b0 += 1
                    b1 = (1 << b0) - 1
                a0 += 1
                a1 = (1 << a0) - 1
            dp[i] = min(dp[i], a0 + (0 if a1 == i else 1 + dp[a1-i]))
        # print(dp)
        return dp[-1]

    # 这个也太快了吧（52ms）
    # 应该需要什么数学方法来证明，为什么else那里的分支就是这样的状态
    def racecar_dp(self, target: int) -> int:
        def race(t):
            if t not in dp:
                n = t.bit_length()
                if (1 << n) - 1 == t:  # 如果刚好是全A指令就能到达的，如1/3/7
                    dp[t] = n
                else:  
                    # （形如AAARAA+dp[]）先n次A到达2^n-1后再R，已操作n+1次，然后转换为从2^n-1到t的正向问题的指令次数
                    dp[t] = n+1+race((1 << n)-1-t)
                    for m in range(n-1):  # 2^m < 2^(n-1)
                        # (形如AAARAAR+dp[])先n-1次A到达2^(n-1)-1后再R，然后m次A往回走，再R变为正向，已指令n-1+2+m次，
                        # 接着转换为剩余差值即t-(2^(n-1)-1)+(2^m-1)的正向问题即可
                        dp[t] = min(dp[t], n + m + 1 + race(t - (1 << n - 1) + (1 << m)))
            return dp[t]
        dp = {0: 0}
        return race(target)


# @lc code=end
if __name__ == "__main__":
    res = Solution().racecar(1024)
    print(res)
