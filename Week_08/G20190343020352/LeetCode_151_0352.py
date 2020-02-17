class Solution:
    def reverseWords(self, s: str) -> str:
        import re
        str1 = re.findall(r'\S+', s)
        if len(str1) == 0:
            return ''
        str1 = str1[::-1]
        str2 = ''
        for i in range(len(str1) -1):
            str2 += (str1[i] + ' ')
        return str2 + str1[-1]
