#解法1
class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        row, col = len(t), len(s)
        dp = [[1] * (col + 1)] + [[0] * (col + 1) for _ in range(row)]

        for i in range(1, row + 1):
            for j in range(1, col + 1):
                if t[i - 1] == s[j - 1]:
                    dp[i][j] = dp[i][j-1] + dp[i - 1][j - 1]
                else:
                    dp[i][j] = dp[i][j-1]
        return dp[-1][-1]

#解法2
class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        l1, l2 = len(s)+1, len(t)+1
        cur = [0] * l2
        cur[0] = 1
        for i in xrange(1, l1):
            pre = cur[:]
            for j in xrange(1, l2):
                cur[j] = pre[j] + pre[j-1]*(s[i-1] == t[j-1])
        return cur[-1]
