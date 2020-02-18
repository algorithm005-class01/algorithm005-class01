class Solution:
    def reverseWords(self, s: str) -> str:
        if not s:
            return ''
        strList = s.split(' ')
        result = ''
        for word in strList:
            temp = ''
            for i in range(len(word)):
                temp += word[len(word) - i - 1]
            result += ' ' + temp
        return result.strip()


if __name__ == "__main__":
    solution = Solution()
    print(solution.reverseWords("Let's take LeetCode contest"))