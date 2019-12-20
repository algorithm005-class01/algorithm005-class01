class Solution:

    def trap(self, height: list) -> int:
        if height is None:
            return 0
        length = len(height)
        if length < 2:
            return 0
        L = 0
        R = length - 1
        area = 0
        leftMax, rightMax = 0, 0
        while L < R:
            if height[L] < height[R]:
                if height[L] >= leftMax:
                    leftMax = height[L]
                else:
                    area = area + (leftMax - height[L])
                L = L + 1
            else:
                if height[R] >= rightMax:
                    rightMax = height[R]
                else:
                    area = area + (rightMax - height[R])
                R = R - 1
        return area