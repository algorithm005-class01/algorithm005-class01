# 22. Generate Parentheses
from collections import deque

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def backtrack(s = '', left = 0, right = 0):
            if left == n and right == n:
                res.append(s)
                # return
            if left < n:
                backtrack(s+'(', left+1, right)
            if right < left:
                backtrack(s+')', left, right+1)
            
        res = []
        backtrack()
        return res

if __name__ == "__main__":
    solution = Solution()
    print(solution.generateParenthesis(3))
