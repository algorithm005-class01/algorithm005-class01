class Solution:
    def numDecodings(self, s):
        # dic = {chr(ord('A')+i):i+1 for i in range(26)}
        if not s: return 0
        if len(s)==1 and int(s)>0: return 1
        if int(s[0])==0: return 0
        dp = [0 for _ in range(len(s)+1)]
        dp[0],dp[1] = 1,1
        for i in range(2,len(dp)):
            tmp = int(s[i-2:i])
            if 9 < tmp < 27:
                dp[i] = dp[i-2]
            if s[i-1] != '0':
                dp[i] += dp[i-1]
        return dp[-1]
