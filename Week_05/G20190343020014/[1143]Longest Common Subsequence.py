#给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
#
# 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
#例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
#
# 若这两个字符串没有公共子序列，则返回 0。
#
#
#
# 示例 1:
#
# 输入：text1 = "abcde", text2 = "ace"
#输出：3
#解释：最长公共子序列是 "ace"，它的长度为 3。
#
#
# 示例 2:
#
# 输入：text1 = "abc", text2 = "abc"
#输出：3
#解释：最长公共子序列是 "abc"，它的长度为 3。
#
#
# 示例 3:
#
# 输入：text1 = "abc", text2 = "def"
#输出：0
#解释：两个字符串没有公共子序列，返回 0。
#
#
#
#
# 提示:
#
#
# 1 <= text1.length <= 1000
# 1 <= text2.length <= 1000
# 输入的字符串只含有小写英文字符。
#
# Related Topics 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def longestCommonSubsequence0(self, text1, text2):
        # 暴力解法， 先求出子序列， 再比较
        sub1 = self.subsequence(text1)
        sub2 = self.subsequence(text2)
        max_l = 0
        for s in sub1:
            if len(s) > max_l and s in sub2:
                max_l = max(len(s), max_l)
                print(max_l, s)
        return max_l

    def subsequence(self, s):
        res = []

        def backtrack(p, n):
            if p:
                res.append(''.join(p))
            for i in range(n, len(s)):
                if p and (s[i] in p or i < s.index(p[-1])):
                    continue
                p.append(s[i])
                backtrack(p, n + 1)
                p.pop()

        backtrack([], 0)
        return res

    # res = []
    # def bc(p, n):
    #     if p:
    #         res.append(p)
    #     for i in range(n, len(text1)):
    #         if text1[i] in p:
    #             continue
    #         bc(p + text1[i], n + 1)
    #         # p.append(text1[i])
    #         # bc(p, n + 1)
    #         # p.pop()
    # bc("", 0)
    # print(len(res), len(set(res)))
    # for x in sorted(res, key=len):
    #     print(x)

    def longestCommonSubsequence(self, text1, text2):
        """
                        dp[i - 1][j - 1] + 1              text1[i-1]=text2[j-1]
            dp[i][j] =
                        Max( dp[i - 1][j], dp[i][j - 1]   text1[i-1] != text2[j-1]
                  a  c  d
              [0, 0, 0, 0]
            a [0, 1, 1, 1]
            b [0, 1, 1, 1]
            c [0, 1, 2, 2]
            d [0, 1, 2, 2]
            e [0, 1, 2, 3]

        """
        m, n = len(text1), len(text2)
        if m == 0 or n == 0:
            return 0
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[m][n]


    def longestCommonSubsequence2(self, text1, text2):
            """
            暴力递归
            """
            def dp(i, j):
                if i == - 1 or j == -1:
                    return 0
                if text1[i] == text2[j]:
                    return dp(i - 1, j - 1) + 1
                else:
                    return max(dp(i - 1, j), dp(i, j - 1))
            return dp(len(text1) - 1, len(text2) - 1)





#leetcode submit region end(Prohibit modification and deletion)
assert Solution().longestCommonSubsequence("abcde", "ace") == 3
assert Solution().longestCommonSubsequence("ubmrapg", "ezupkr") == 2
assert Solution().longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg") == 3


