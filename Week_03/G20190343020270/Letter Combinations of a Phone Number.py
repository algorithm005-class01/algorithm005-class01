# 17. Letter Combinations of a Phone Number

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
        
        def search(s, digits, i, res):
            if i == len(digits):
                res.append(s)
                return
            
            letters = phone.get(digits[i])
            for j in range(len(letters)):
                search(s+letters[j], digits, i+1, res)
        
        res = []
        if digits:
            search('', digits, 0, res)
        return res
        
        def trackback(combination, next_digits):
            if len(next_digits) == 0:
                output.append(combination)
            else:
                for letter in phone[next_digits[0]]:
                    trackback(combination+letter, next_digits[1:])
        
        output = []
        if digits:
            trackback('', digits)
        return output