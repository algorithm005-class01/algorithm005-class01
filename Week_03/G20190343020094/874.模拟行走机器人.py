#
# @lc app=leetcode.cn id=874 lang=python3
#
# [874] 模拟行走机器人
#
from typing import List
# @lc code=start
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        distance = 0
        dx, dy, x, y = 0, 1, 0, 0
        obs_dict = {}
        for obs in obstacles:
            obs_dict[tuple(obs)] = 0
        for command in commands:
            if command == -2:
                dx, dy = -dy, dx
                continue
            if command == -1:
                dx, dy = dy, -dx
                continue
            for j in range(command):
                next_x, next_y = x + dx, y + dy
                if (next_x, next_y) in obs_dict: break
                x, y = next_x, next_y
                distance = max(distance, x*x+y*y)
        return distance
            



        
# @lc code=end
if __name__ == "__main__":
    a = [4,-1,4,-2,4]
    b = [[2,4]]
    res = Solution().robotSim(a,b)
    print(res)
