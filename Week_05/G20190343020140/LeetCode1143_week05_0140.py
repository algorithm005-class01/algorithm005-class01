#解法1，递归，自底向上
class Solution:
        def longestCommonSubsequence(self, text1, text2: str) -> int:
            return self.helper(text1, text2, len(text1)-1, len(text2)-1)
            
        def helper(self, text1, text2, i, j):
            if i == -1 or j == -1:
                return 0
            if text1[i] == text2[j]:
                return 1 + self.helper(text1, text2, i - 1, j - 1)
            else:
                return max(self.helper(text1, text2, i-1, j), self.helper(text1, text2, i, j - 1))


#解法2：记忆化递归，加上memo
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        m, n = len(text1),len(text2)
        memo = [[0]*(n+1) for _ in range(m+1)]
        return self.dp(m-1,n-1,text1,text2,memo)

    def dp(self,i,j,text1,text2,memo):
        if memo[i][j] == 0:
            if i == -1 or j == -1:
                return 0
            if text1[i] == text2[j]:
                memo[i][j] = 1 + self.dp(i-1,j-1,text1,text2,memo) 
            else:
                memo[i][j] = max(self.dp(i-1,j,text1,text2,memo),self.dp(i,j-1,text1,text2,memo))
        return memo[i][j]

#解法3：DP,二维数组,自顶向下
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        m, n = len(text1), len(text2)
        dp = [[0] * (n+1) for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        return dp[-1][-1]

#解法4，用两个二维数组，自顶向下
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        if len(text1) < len(text2):
            text1, text2 = text2,text1
        l1,l2 = len(text1),len(text2)
        curr = [0] * (l2+1)
        for i in range(l1):
            curr,pre = [0] * (l2 + 1), curr
            for j in range(l2):
                curr[j+1] = pre[j] + 1 if text1[i] == text2[j] else max(curr[j], pre[j+1])
        return curr[l2]
