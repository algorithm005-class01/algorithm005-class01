"""17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

"""


class Solution(object):
    def letter_combinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []

        phone = ['', '*', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        rs = []

        def dfs(tmp, index):
            if index == len(digits):
                rs.append(tmp)
                return
            letters = phone[ord(digits[index]) - ord('0')]
            for i in letters:
                dfs(tmp + i, index + 1)

        dfs('', 0)
        return rs

    def letter_combinations2(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []

        rs = ['']
        phone = ['', '*', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        for d in digits:
            letters = phone[ord(d) - ord('0')]
            last_size = len(rs)
            for i in xrange(last_size):
                tmp = rs.pop(0)
                for l in letters:
                    rs.append(tmp + l)
        return rs
