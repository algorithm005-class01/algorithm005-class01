#解法1
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = ""
        for i in xrange(len(s)):
            # odd case
            tmp = self.helper(s, i, i)
            if len(tmp) > len(res):
                res = tmp
            # even case
            tmp = self.helper(s, i, i+1)
            if len(tmp) > len(res):
                res = tmp
        return res
 
# get the longest palindrome, l, r are the middle indexes   
# from inner to outer
    def helper(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1; r += 1
        return s[l+1:r]

#解法2
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s ==s[::-1]:
            return s 
        res = s[0]
        for i in range(len(s)):
            p_odd = self.spread(s,i,i)
            p_even = self.spread(s,i,i+1)

            res = max(p_odd,p_even,res,key = len)
        return res
        

    def spread(self,s,left,right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left+1:right]

#解法3
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s == s[::-1]:
            return s 
        max_len = 1
        res = s[0]
        for i in range(len(s)-1):
            for j in range(i+1,len(s)):
                if j + 1 - i > max_len and s[i:j+1] == s[i:j+1][::-1]:
                    max_len = j + 1 - i 
                    res = s[i:j+1]
        return res
