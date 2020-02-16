class Solution:
    def myAtoi(self, str: str) -> int:
        if not str:
            return 0
        index, isNeg = 0, 1
        # MIN_VALUE = 0x80000000
        INT_MIN = -1 << 31
        # MAX_VALUE = 0x7fffffff
        INT_MAX = (1 << 31) - 1
        while index < len(str) and str[index] == ' ':
                index += 1
        if index >= len(str) or (ord(str[index]) > ord('9') and str[index] not in ['+', '-']):
            return 0
        if str[index] == '+':
            index += 1
        elif str[index] == '-':
            index += 1
            isNeg = -1
        result = 0
        while index < len(str):
            cur = ord(str[index])
            if cur > ord('9') or cur < ord('0'):
                break
            if result > INT_MAX // 10 or (result == INT_MAX // 10 and (cur - ord('0')) > INT_MAX % 10):
                return INT_MAX
            if result < INT_MIN // 10 or (result == -214748364 and (cur - ord('0')) > 8):
                return INT_MIN
            result = result * 10 + isNeg * (cur - ord('0'))
            index += 1
        return result


if __name__ == "__main__":
    solution = Solution()
    print(solution.myAtoi("+"))

        
