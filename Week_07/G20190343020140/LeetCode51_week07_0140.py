#解法1：
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        ans = []

        def dfs(pos=[], row=0, col=0, pie=0, na=0):
            if row == n:
                ans.append(pos)
                return
            bits = ~(col | pie | na) & ((1 << n) - 1)
            while bits:
                p = bits & -bits
                line = ''.join(['Q' if p >> i & 1 else '.' for i in range(n)])
                dfs(pos + [line], row + 1, col | p,
                    (pie | p) << 1, (na | p) >> 1)
                bits &= bits - 1

        dfs()
        return ans
