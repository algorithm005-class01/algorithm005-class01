#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#
from typing import List
# @lc code=start
class Solution:
    # 超哥传授的从后贪心
    def canJump(self, nums: List[int]) -> bool:
        if not nums: return False

        endReachable = len(nums) - 1
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] + i >= endReachable:
                endReachable = i
        return endReachable == 0

    # O(n^2)超时了
    # def canJump(self, nums: List[int]) -> bool:
    #     if not nums: return False
    #     length = len(nums)
    #     jump = [False if i != 0 else True for i in range(length)]
        
    #     for i in range(length):
    #         if jump[i]:
    #             for step in range(i, i + nums[i] + 1):
    #                 if step < length:
    #                     jump[step] = True
        
    #     return jump[-1] == True                




# @lc code=end
if __name__ == "__main__":
    a = [2,3,1,1,4]
    res = Solution().canJump(a)
    print(res)
