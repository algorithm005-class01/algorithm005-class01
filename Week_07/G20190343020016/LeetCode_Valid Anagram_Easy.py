"""
242. Valid Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


"""


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 定义默认布尔值参与后续运算
        result = True
        # 利用 Python 数据结构 set 去重去序
        set_tmp = set(s)
        # 先判断组成字符串的各个字符元素是否一致
        if set_tmp == set(t):
            for i in set_tmp:
                # 利用逻辑运算符判断各个字符元素的数量一致，均为 True 才输出 True
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        return (result)
