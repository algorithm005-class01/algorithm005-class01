# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/trapping-rain-water/"""

# Key: 每个位置能装水量等于其左右两边最大柱二者较小值减去本身
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        i, j = 0, len(height) - 1
        left_max, right_max = height[i], height[j]
        res = 0
        while i < j:
            if height[i] < height[j]:
                # 依赖left_max
                if left_max > height[i]:
                    res += left_max - height[i]
                else:
                    left_max = height[i]
                i += 1
            else:
                # 依赖right_max
                if right_max > height[j]:
                    res += right_max - height[j]
                else:
                    right_max = height[j]
                j -= 1
        return res


if __name__ == '__main__':
    height = [0, 4, 7, 6, 2, 9, 3, 6, 4, 0, 3]
    print(Solution().trap(height))
