#解法 1
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        memo = {}
        def dp(i,j):
            if (i,j) in memo:
                return memo[(i,j)]
            if j == len(p):
                return i == len(s)
            first = i < len(s) and p[j] in {s[i],'.'}
            if j <= len(p) -2 and p[j+1] == '*':
                ans = dp(i,j+2) or first and dp(i+1,j)
            else:
                ans = first and dp(i+1,j+1)
            memo[(i,j)] = ans
            return ans
        return dp(0,0)

#解法2
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        dp = [[False] * (len(s) + 1) for _ in range(len(p) + 1)]
        dp[0][0] = True
        for i in range(1,len(p)):
            dp[i+1][0] = dp[i-1][0] and p[i] == '*'
        for i in range(len(p)):
            for j in range(len(s)):
                if p[i] == '*':
                    dp[i+1][j+1] = dp[i-1][j+1] or dp[i][j+1]
                    if p[i-1] == s[j] or p[i-1] == '.':
                        dp[i+1][j+1] |= dp[i+1][j]
                else:
                    dp[i+1][j+1] = dp[i][j] and (p[i] == s[j] or p[i] == '.')
        return dp[-1][-1]

#解法3
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        s, p = ' ' + s, ' ' + p
        lens,lenp = len(s), len(p)
        dp = [[0] * lenp for _ in range(lens)]
        dp[0][0] = 1

        for j in range(1,lenp):
            if p[j] == '*':
                dp[0][j] = dp[0][j-2]
        for i in range(1,lens):
            for j in range(1,lenp):
                if p[j] in {s[i],'.'}:
                    dp[i][j] = dp[i-1][j-1]
                elif p[j] == '*':
                    dp[i][j] = dp[i][j-2] or int(dp[i-1][j] and p[j-1] in {s[i],'.'})
        
        return bool(dp[-1][-1])
