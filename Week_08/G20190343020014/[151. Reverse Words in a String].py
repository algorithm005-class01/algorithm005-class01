class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.split(" ")
        return " ".join([s[i] for i in range(len(s) - 1, -1 , -1) if s[i]])
