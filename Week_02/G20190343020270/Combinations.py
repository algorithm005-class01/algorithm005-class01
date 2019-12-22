# 77. Combinations

# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

# Example:

# Input: n = 4, k = 2
# Output:
# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k > n:
            return []
        def backtrack(first = 1, cur = []):
            if len(cur) == k:
                output.append(cur[:])
            for i in range(first, n+1):
                cur.append(i)
                backtrack(i+1, cur)
                cur.pop()
        output = []
        backtrack()
        return output