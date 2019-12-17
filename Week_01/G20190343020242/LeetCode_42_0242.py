#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#
# https://leetcode-cn.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (47.27%)
# Likes:    721
# Dislikes: 0
# Total Accepted:    41.4K
# Total Submissions: 87.3K
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
#
#
#
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
# Marcos 贡献此图。
#
# 示例:
#
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
#
#


# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        # HOMEWORK:
        # 暴力
        # n = len(height)
        # total_volume = 0
        # for i in range(1, n - 1):
        #     h = min(max(height[:i]), max(height[i + 1:]))
        #     if h > height[i]:
        #         total_volume += h - height[i]
        # return total_volume

        # 栈
        total_volume, i = 0, 0
        stack = []
        while i < len(height):
            while stack != [] and height[i] > height[stack[-1]]:
                top = stack.pop()
                if stack == []: break
                span = i - stack[-1] - 1
                h = min(height[stack[-1]], height[i]) - height[top]
                total_volume += span*h
            stack.append(i)
            i += 1
        return total_volume


# @lc code=end
