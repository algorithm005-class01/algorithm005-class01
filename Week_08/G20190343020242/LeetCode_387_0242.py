#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#
# https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
#
# algorithms
# Easy (41.87%)
# Likes:    174
# Dislikes: 0
# Total Accepted:    57.7K
# Total Submissions: 134.7K
# Testcase Example:  '"leetcode"'
#
# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
# 
# 案例:
# 
# 
# s = "leetcode"
# 返回 0.
# 
# s = "loveleetcode",
# 返回 2.
# 
# 
# 
# 
# 注意事项：您可以假定该字符串只包含小写字母。
# 
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        from collections import Counter
        counts = Counter(s)
        
        for i, char in enumerate(s):
            if counts[char] == 1:
                return i
        return -1



# @lc code=end

s = "leetcode"
ans = Solution().firstUniqChar(s)
print(ans)