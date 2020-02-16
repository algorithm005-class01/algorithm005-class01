"""151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

 
示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 
"""


class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s_list = list(s)
        s_list = self.reverse(s_list, 0, len(s_list)-1)
        s_list = self.reverse_word(s_list)
        s_list = self.trip_side(s_list)
        s_list = self.trip_sapce(s_list)
        return ''.join(s_list)

    def reverse(self, s_list, l, r):
        while l < r:
            s_list[l], s_list[r] = s_list[r], s_list[l]
            l += 1
            r -= 1
        return s_list

    def reverse_word(self, s_list):
        l, r = 0, 0
        while r < len(s_list):
            while r < len(s_list) and not s_list[r].isspace():
                r += 1 #: 走到了非空字符后的第一个空字符
            self.reverse(s_list, l, r-1) #: 减去一位
            r += 1
            l = r
        return s_list

    def trip_side(self, s_list):
        if ''.join(s_list).isspace():
            return []
        l, r = 0, len(s_list) - 1
        while l < r and s_list[l].isspace():
            l += 1
        while l < r and s_list[r].isspace():
            r -= 1
        return s_list[l:r+1]  #:数组为左闭右开

    def trip_sapce(self, s_list):
        if not s_list:
            return []
        res = [s_list[0]]
        for i in range(1, len(s_list)):
            if res[-1].isspace() and s_list[i].isspace():
                continue
            res.append(s_list[i])
        return res