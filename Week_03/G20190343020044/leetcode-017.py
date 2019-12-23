class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []
        if len(digits) == 1:
            return self.letters(digits)
        else:
            sub = digits[:-1]
            res = self.addone(digits[-1], self.letterCombinations(sub))
            return res

    def addone(self, digit: str, prefix: List[str]) -> List[str]:
        res = []
        for ch in self.letters(digit):
            for s in prefix:
                res.append(s + ch)
        return res
    
    def letters(self, digit: str) -> List[str]:
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
        return phone[digit]