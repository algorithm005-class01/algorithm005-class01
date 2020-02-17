class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        if not s:
            return None
        wordList = list(s)
        for i in range(0, len(wordList), 2 * k):
            wordList[i : i + k] = reversed(wordList[i : i + k])
        return "".join(wordList)
