class Solution:
    def toLowerCase(self, str: str) -> str:
        if not str:
            return None
        result = ''
        for i in range(len(str)):
            if str[i] >= 'A' and str[i] <= 'Z':
                temp = chr(ord(str[i]) + 32)
                result += temp
            else:
                result += str[i]

        return result




if __name__ == "__main__":
    print('AB'.lower())
    solution = Solution()
    print(solution.toLowerCase('Hello'))