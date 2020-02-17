class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ''
        length = len(s)
        if length < 2:
            return s
        dp = [[False] * length for _ in range(length)]

        for i in range(length):
            dp[i][i] = True
        
        start = 0
        maxLength = 1
        for j in range(1, length):
            for i in range(0, j):
                if s[i] == s[j]:
                    if j - i < 3:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                else:
                    dp[i][j] = False
                
                if dp[i][j]:
                    if j - i + 1 > maxLength:
                        maxLength = j - i + 1
                        start = i
        return s[start : start + maxLength]





if __name__ == "__main__":
    pass
