class Solution:
    def firstUniqChar(self, s: str) -> int:
        bag = {}
        for i in range(len(s)):
            if s[i] not in bag.keys():
                bag[s[i]] = i
            else:
                bag[s[i]] = -1
        
        ans = len(s)

        for k in bag.keys():
            if bag[k] < ans and bag[k] != -1:
                ans = bag[k]
        if ans == len(s):
            return -1
        return ans