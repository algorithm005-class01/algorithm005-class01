"""242. Valid Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
"""


class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype:
        """
        if len(s) != len(t):
            return False
    
        count = [0] * 26
        for i, j in zip(s, t):
            count[ord(i) - ord('a')] += 1
            count[ord(j) - ord('a')] -= 1
        return not any(count)