#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
import re
class Solution:
    # https://leetcode-cn.com/problems/string-to-integer-atoi/solution/python-1xing-zheng-ze-biao-da-shi-by-knifezhu/
    # ^：匹配字符串开头
    # [\+\-]：代表一个+字符或-字符
    # ?：前面一个字符可有可无
    # \d：一个数字
    # +：前面一个字符的一个或多个
    # \D：一个非数字字符
    # *：前面一个字符的0个或多个
    # 32ms
    def myAtoi_re(self, str: str) -> int:
        return max(min(int(*re.findall('^[\+\-]?\d+', str.lstrip())), 2**31 - 1), -2**31)

    # 还有考验基本功的方法
    # 1.strip处理左边的空格
    # 2.处理符号位
    # 3.处理数字大小
    # 4.处理数值越界问题
    # 32ms
    def myAtoi(self, str: str) -> int:
        ls = list(str.strip())
        if len(ls) == 0: return 0

        sign = -1 if ls[0] == '-' else 1
        if ls[0] in ['-', '+']: del ls[0]
        res, i = 0, 0

        while i < len(ls) and ls[i].isdigit():
            res = res * 10 + ord(ls[i]) - ord('0')
            i += 1
        return max(-2**31, min(sign*res, 2**31-1))

# @lc code=end

if __name__ == "__main__":
    s = " "
    res = Solution().myAtoi(s)
    print(res)

