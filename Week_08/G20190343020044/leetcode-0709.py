class Solution:
    def toLowerCase(self, str: str) -> str:
        newstr = ''
        for c in str:
            if 'A'<= c <= 'Z':
                c = chr(ord(c) + ord('a')-ord('A'))
            newstr += c
        return newstr