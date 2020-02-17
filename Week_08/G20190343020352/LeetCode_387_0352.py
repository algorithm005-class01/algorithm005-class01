class Solution:
    def firstUniqChar(self, s: str) -> int:
        if not s:
            return -1
        strMap = {}
        for i in range(len(s)):
            strMap[s[i]] = strMap.get(s[i], 0) + 1
        for i in range(len(s)):
            if strMap[s[i]] == 1:
                return i
        return -1