#解法1
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        arr = [0 for i in range(26)]
        for i in range(len(s)):
            arr[ord(s[i])-97]+=1
            
        for j in range(len(s)):
            if(arr[ord(s[j])-97] == 1):
                return j
        return -1

#解法2
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return -1
        count = collections.Counter(s)
        
        # find the index
        for idx, ch in enumerate(s):
            if count[ch] == 1:
                return idx
        return -1

#解法3
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        for l in s:
            if l not in d:
                d[l] = 1
            else:
                d[l] += 1
        index = -1
        for i in range(len(s)):
            if d[s[i]] == 1:
                index = i
                break 
        return index

#解法4
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:  
            return -1
        if len(s) == 1: 
            return 0
        
        for i, ch in enumerate(s):
            if ch not in s[:i]+s[i+1:]:
                return i
        return -1
        
