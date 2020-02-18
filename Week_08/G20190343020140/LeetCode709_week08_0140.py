#解法1
class Solution(object):
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        res = ''
        for s in str:
            if s >= 'A' and s <= 'Z':
                s = chr(ord(s) + 32)
            res += s 
        return res

#解法2
class Solution(object):
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        res = ''
        for ch in str:
            res += ch.lower()
        return res

#解法3
class Solution(object):
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        return str.lower()
