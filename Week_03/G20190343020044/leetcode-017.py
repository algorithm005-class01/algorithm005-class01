class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
        if not digits: return []
        if len(digits) == 1: return phone[digits]
        
        def addone(prefix: List[str], digit: str) -> List[str]:
            res = []
            for ch in phone[digit]:
                for s in prefix:
                    res.append(s + ch)
            return res
        sub = digits[:-1]
        return addone(self.letterCombinations(sub),digits[-1])