# -*- coding: utf-8 -*-
# @Time    : 2019-12-13 09:49
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_84_1034.py
# @Software: PyCharm

# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。
# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
#
# 示例:
#
# 输入: [2,1,5,6,2,3]
# 输出: 10
# Related Topics 栈 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        题目：84.柱状图中的最大矩形面积（https://leetcode-cn.com/problems/largest-rectangle-in-histogram/）
        标签：栈 数组
        学号：1034（五期一班三组）
        :type heights: List[int]
        :rtype: int
        """
        stack, max_area = [-1], 0
        for i in xrange(0, len(heights)):
            while stack[-1] > -1 and heights[stack[-1]] >= heights[i]:
                max_area = max(max_area, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)

        while stack[-1] > -1:
            max_area = max(max_area, heights[stack.pop()] * (len(heights) - stack[-1] - 1))
        return max_area

# leetcode submit region end(Prohibit modification and deletion)
