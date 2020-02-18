#解法1
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        sign = 1                # 整数符号　+1 or -1
        ans = 0                 # 累计结果
        flag = True   
        for i in range(len(str)):
            if flag:
                if str[i] == ' ':
                    continue
                elif str[i] == '+' or str[i] == '-':
                    sign = 44 - ord(str[i])
                    if i + 1 < len(str) and not str[i+1].isdigit():
                        return 0
                elif str[i].isdigit():
                    ans = ans * 10 + ord(str[i]) - ord('0')
                else:
                    return 0
                flag = False

            elif str[i].isdigit():
                ans = ans * 10 + ord(str[i]) - ord('0')
            else:
                break 
        MAX_INT = 2147483647
        MIN_INT = -2147483648
        ans *= sign
        if ans < -2 ** 31:
            return MIN_INT
        elif ans > 2 ** 31 -1:
            return MAX_INT
        return ans


