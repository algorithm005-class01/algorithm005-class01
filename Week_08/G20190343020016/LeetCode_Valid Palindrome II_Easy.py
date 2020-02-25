"""
680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


"""


class Solution:
    def validPalindrome(self, s: str) -> bool:
        if s == s[::-1]:
            return True
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] != s[j]:
                a = s[:i] + s[i + 1:]
                if a == a[::-1]:
                    return True
                b = s[:j] + s[j + 1:]
                if b == b[::-1]:
                    return True
                return False
            else:
                i += 1
                j -= 1
        return False
