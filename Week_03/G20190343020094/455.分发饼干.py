#
# @lc app=leetcode.cn id=455 lang=python3
#
# [455] 分发饼干
#
from typing import List
# @lc code=start
# class Solution:
#     def findContentChildren(self, g: List[int], s: List[int]) -> int:
#         g.sort()
#         s.sort()
#         counts = 0
#         s_pointer = 0
#         for child_appetite in g:
#             for i, _ in enumerate(s, start=s_pointer):
#                 if i + 1 > len(s):
#                     break
#                 if s[i] >= child_appetite:
#                     s_pointer = i + 1
#                     counts += 1
#                     break
#         return counts

class Solution(object):
    def findContentChildren(self, g, s):
        g.sort()
        s.sort()
        
        childi = 0
        cookiei = 0
        
        while cookiei < len(s) and childi < len(g):
            if s[cookiei] >= g[childi]:
                childi += 1
            cookiei += 1
        
        return childi

        
# @lc code=end
if __name__ == "__main__":
    g = [1,2,3]
    s = [3]
    res = Solution().findContentChildren(g, s)
    print(res)
