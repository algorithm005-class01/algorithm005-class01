# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
#
#
#
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
#
# 示例:
#
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
# Related Topics 栈 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height:
            return 0
        res, n, stack = 0, len(height), []
        for i in range(n):
            while stack and height[stack[-1]] < height[i]:
                tmp = stack.pop()
                if not stack: break
                res += (min(height[i], height[stack[-1]]) - height[tmp]) * (i - stack[-1] - 1)
            stack.append(i)
        return res

# leetcode submit region end(Prohibit modification and deletion)
