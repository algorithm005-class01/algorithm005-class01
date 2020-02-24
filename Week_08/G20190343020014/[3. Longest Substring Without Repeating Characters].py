# 暴力， 求出所有子串， 取最长
# 使用hash 表记录子串 + 双指针
# 滑动窗口

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i, j, n, st, ans = 0, 0, len(s), set(), 0
        while i < n and j < n:
            if s[j] not in  st:
                st.add(s[j])
                j += 1
                ans = max(ans, len(st))
            else:
                st.remove(s[i])
                i += 1
        return ans
