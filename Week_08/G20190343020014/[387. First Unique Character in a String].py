class Solution:
    def firstUniqChar(self, s: str) -> int:
        mp = {}
        for i in range(len(s)):
            if mp.get(s[i]) is not None:
                mp[s[i]] = -1
            else:
                mp[s[i]] = i

        for m in mp:
            if mp.get(m) > -1:
                return mp.get(m)
        return -1
