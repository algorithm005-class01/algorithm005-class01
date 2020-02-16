#
# @lc app=leetcode.cn id=818 lang=python3
#
# [818] 赛车
#
# https://leetcode-cn.com/problems/race-car/description/
#
# algorithms
# Hard (29.97%)
# Likes:    29
# Dislikes: 0
# Total Accepted:    732
# Total Submissions: 2.4K
# Testcase Example:  '3'
#
# 你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）
#
# 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。
#
# 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。
#
# 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。
# (当前所处位置不变。)
#
# 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。
#
# 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。
#
# 示例 1:
# 输入:
# target = 3
# 输出: 2
# 解释:
# 最短指令列表为 "AA"
# 位置变化为 0->1->3
#
#
# 示例 2:
# 输入:
# target = 6
# 输出: 5
# 解释:
# 最短指令列表为 "AAARA"
# 位置变化为 0->1->3->7->7->6
#
#
# 说明:
#
#
# 1 <= target（目标位置） <= 10000。
#
#
#


# @lc code=start
class Solution:

    def racecar(self, target: int) -> int:
        """
        1. 连续 A（加速）指令 k 次后，位置依次为：1,3,7,15,31,63,127,255,511,1023 即：2^k-1
        2. 因此当 target = 2^k - 1 时，需要指令数 k
        3. target 位于 k 与 k+1 次指令位置中间时：
            1. 先超过 target 移动到 2^k-1 处再返回，此时剩下距离 res = 2^k-1-i，
            所需步骤为 dp[res]，总指令数：k + 1 + dp[res]
            2. 或者先移动到 2^(k-1) 处，指令数 k-1；再 R（倒车）并加速 j 次，此时剩余距离 
            res = i- (2^（k-1)）+ 2^j；总指令数为 k-1 + 1+j+1 + dp[res];
            j 遍历 0~k-1，求出最小值
            3. 上述两种方案中较小者
        
        4. 初始条件：
        """
        # 初始条件：
        dp = [0, 1, 4] + [float('inf')] * target

        for t in range(3, target + 1):
            k = t.bit_length()

            # 在 2^k-1 处
            if t == (1 << k) - 1:
                dp[t] = k
                continue

            # 移动到 2^(k-1)-1 处：
            res = t - ((1 << (k - 1)) - 1)
            for j in range(k - 1):
                dp[t] = min(dp[t], k - 1 + j + 2 + dp[res + (1 << j) - 1])

            # 移动到 2^k-1 处
            res = (1 << k) - 1 - t
            dp[t] = min(dp[t], k + 1 + dp[res])
        return dp[target]


# @lc code=end

for i in range(20):
    print(i, Solution().racecar(i))