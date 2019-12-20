#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
import sys
class Solution:
    # 优雅双指针
    def trap(self, height) -> int:
        length = len(height)
        if length < 3:
            return 0

        p_l = 0
        p_r = length - 1
        
        max_l = 0
        max_r = 0
        trapped = 0
        while p_l < p_r:
            if height[p_l] < height[p_r]:
                if height[p_l] >= max_l:
                    max_l = height[p_l]
                else:
                    trapped += max_l - height[p_l]
                p_l += 1
            else:
                if height[p_r] >= max_r:
                    max_r = height[p_r]
                else:
                    trapped += max_r - height[p_r]
                p_r -= 1
        return trapped

    # 记录的棒子的最近相关性？
    # def trap(self, height) -> int:
    #     length = len(height)
    #     if length < 3: return 0
    #     left_max = [0] * length
    #     right_max = [0] * length
    #     left_max[0] = height[0]
    #     right_max[length-1] = height[length-1]
    #     ans = 0

    #     for i in range(1, length, 1):
    #         left_max[i] = max(left_max[i-1], height[i])
    #     for i in range(length-2, 0, -1):
    #         right_max[i] = max(right_max[i+1], height[i])
    #         ans += min(left_max[i], right_max[i]) -height[i]
    #     return ans

    # 暴力求解
    # def trap(self, height) -> int:
    #     length = len(height)
    #     if length < 3:
    #         return 0

    #     trapped = 0
    #     for i in range(1, length-1):
    #         left_max = 0
    #         right_max = 0
    #         for l in range(0, i):
    #             if height[l] > left_max:
    #                 left_max = height[l]

    #         for r in range(i, length):
    #             if height[r] > right_max:
    #                 right_max = height[r]
            
    #         d = min(left_max, right_max) - height[i]
    #         if d > 0:
    #             trapped += d
    #     return trapped

# @lc code=end