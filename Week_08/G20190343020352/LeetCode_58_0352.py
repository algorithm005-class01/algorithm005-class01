class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s:
            return 0
        if s.split(' ') == []:
            return 0
        else:
            return len(s.split(' ')[-1])