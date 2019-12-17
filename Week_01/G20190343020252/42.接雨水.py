# 简单解算
class Solution:
    def trap(self, height: List[int]) -> int:
        ans = 0
        h1 = 0
        h2 = 0
        for i in range(len(height)):
            h1 = max(h1, height[i])
            h2 = max(h2, height[-i-1])
            ans = ans + h1 + h2 - height[i]
        return ans - len(height) * h1


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        if len(height) <= 1:  # 先做一个有效性检查
            return 0

        max_height = 0
        max_height_index = 0

        # 找到最高点
        for i in range(len(height)):
            h = height[i]
            if h > max_height:
                max_height = h
                max_height_index = i

        area = 0

        # 从左边往最高点遍历
        tmp = height[0]
        for i in range(max_height_index):
            if height[i] > tmp:
                tmp = height[i]
            else:
                area = area + (tmp - height[i])

        # 从右边往最高点遍历
        tmp = height[-1]
        for i in reversed(range(max_height_index + 1, len(height))):
            if height[i] > tmp:
                tmp = height[i]
            else:
                area = area + (tmp - height[i])

        return area