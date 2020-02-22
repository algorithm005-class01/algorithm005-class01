class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s:
            return 0
        return len(s.strip().split(" ")[-1])
