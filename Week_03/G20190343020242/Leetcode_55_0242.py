#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#
# https://leetcode-cn.com/problems/jump-game/description/
#
# algorithms
# Medium (37.11%)
# Likes:    408
# Dislikes: 0
# Total Accepted:    49.1K
# Total Submissions: 132K
# Testcase Example:  '[2,3,1,1,4]'
#
# 给定一个非负整数数组，你最初位于数组的第一个位置。
#
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
#
# 判断你是否能够到达最后一个位置。
#
# 示例 1:
#
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
#
#
# 示例 2:
#
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
#
#
#


# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # # 1. 从后向前遍历
        # lastPos = len(nums) - 1
        # for i in range(len(nums) - 1, -1, -1):
        #     if i + nums[i] >= lastPos:  # 从位置 i 可以达到位置 lastPos
        #         lastPos = i  # 问题转化成->可否达到位置 i ？？
        # return lastPos == 0

        # 2. 从左向右遍历
        prevMax = 0
        for i in range(len(nums)):
            if i > prevMax:  # 位置 i 大于其前面所有点能达到的最大位置， 位置 i 就不可达到
                return False
            prevMax = max(prevMax, i + nums[i])  # i 前面所有点能到达的最大位置
        return True


# @lc code=end
